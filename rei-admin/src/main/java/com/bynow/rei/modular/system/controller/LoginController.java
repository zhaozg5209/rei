package com.bynow.rei.modular.system.controller;

import com.bynow.rei.core.base.controller.BaseController;
import com.bynow.rei.core.cache.EhcacheFactory;
import com.bynow.rei.core.cache.ICache;
import com.bynow.rei.core.common.exception.InputInvildException;
import com.bynow.rei.core.common.exception.InvalidKaptchaException;
import com.bynow.rei.core.common.exception.TwoPwdNotMatchException;
import com.bynow.rei.core.log.LogManager;
import com.bynow.rei.core.log.factory.LogTaskFactory;
import com.bynow.rei.core.node.MenuNode;
import com.bynow.rei.core.shiro.ShiroKit;
import com.bynow.rei.core.shiro.ShiroUser;
import com.bynow.rei.core.support.HttpKit;
import com.bynow.rei.core.util.ApiMenuFilter;
import com.bynow.rei.core.util.KaptchaUtil;
import com.bynow.rei.core.util.RegexValidateUtil;
import com.bynow.rei.core.util.ToolUtil;
import com.bynow.rei.modular.system.model.User;
import com.bynow.rei.modular.system.service.IMenuService;
import com.bynow.rei.modular.system.service.IUserService;
import com.bynow.rei.third.rabbitmq.dto.EmailMessage;
import com.google.code.kaptcha.Constants;
import com.google.common.collect.Maps;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 登录控制器
 *
 * @author fengshuonan
 * @Date 2017年1月10日 下午8:25:24
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IUserService userService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    private ICache iCache;



    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        //获取菜单列表
        List<Integer> roleList = ShiroKit.getUser().getRoleList();
        if (roleList == null || roleList.size() == 0) {
            ShiroKit.getSubject().logout();
            model.addAttribute("tips", "该用户没有角色，无法登陆");
            return "/login.html";
        }
        List<MenuNode> menus = menuService.getMenusByRoleIds(roleList);
        List<MenuNode> titles = MenuNode.buildTitle(menus);
        titles = ApiMenuFilter.build(titles);

        model.addAttribute("titles", titles);

        //获取用户头像
        Integer id = ShiroKit.getUser().getId();
        User user = userService.selectById(id);
        String avatar = user.getAvatar();
        model.addAttribute("avatar", avatar);

        return "/index.html";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return REDIRECT + "/";
        } else {
            return "/login.html";
        }
    }

    /**
     * 跳转到注册页面
     */
    @RequestMapping(value = "/regesiter", method = RequestMethod.GET)
    public String regesiter() {
       return "/regesiter.html";
    }

    /**
     * 点击登录执行的动作
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginVali() {

        String username = super.getPara("username").trim();
        String password = super.getPara("password").trim();
        String remember = super.getPara("remember");

        //验证验证码是否正确
        if (KaptchaUtil.getKaptchaOnOff()) {
            String kaptcha = super.getPara("kaptcha").trim();
            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
                throw new InvalidKaptchaException();
            }
        }

        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());

        if ("on".equals(remember)) {
            token.setRememberMe(true);
        } else {
            token.setRememberMe(false);
        }

        currentUser.login(token);

        ShiroUser shiroUser = ShiroKit.getUser();
        super.getSession().setAttribute("shiroUser", shiroUser);
        super.getSession().setAttribute("username", shiroUser.getAccount());

        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), HttpKit.getIp()));

        ShiroKit.getSession().setAttribute("sessionFlag", true);

        return REDIRECT + "/";
    }

    /**
     * 点击注册执行的动作
     */
    @RequestMapping(value = "/regesiter", method = RequestMethod.POST)
    public String regesiterVali(Model model) {

        String username = super.getPara("username").trim();
        String password = super.getPara("password").trim();
        String checkPassword = super.getPara("checkPassword").trim();
        String email = super.getPara("email").trim();
        String code = super.getPara("code").trim();

        if(!password.equals(checkPassword))
                throw new TwoPwdNotMatchException();
        if(!RegexValidateUtil.checkEmail(email))
                throw new InputInvildException();
        if(!EhcacheFactory.getInstance().get("EMAILCACHE",username).equals(code))
                throw new InputInvildException();
        return REDIRECT + "/login.html";
    }

    /**
     *  获得邮箱验证码
     */
    @RequestMapping(value = "/getEmailCode", method = RequestMethod.POST)
    @ResponseBody
    public void getEmailCode(EmailMessage message) {
        if(!RegexValidateUtil.checkEmail(message.getEmail()))
            throw new InputInvildException();
        if(!message.getPassword().equals(message.getCheckPassword()))
            throw new TwoPwdNotMatchException();
        //创建消息
       sendDataMessage("EMAILQUEUE",message);
    }




        /**
         * 退出登录
         */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {
        LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), HttpKit.getIp()));
        ShiroKit.getSubject().logout();
        return REDIRECT + "/login";
    }

    public void sendDataMessage(String queueKey,Object object){
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setMessageId(UUID.randomUUID().toString());
        RabbitTemplate template = new RabbitTemplate();
        Message message = template.getMessageConverter().toMessage(object,messageProperties);
        amqpTemplate.convertAndSend(queueKey,message);
    }
}
