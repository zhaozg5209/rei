package com.bynow.rei.modular.blog.controller;

import com.bynow.rei.core.base.controller.BaseController;
import com.bynow.rei.core.common.exception.BizExceptionEnum;
import com.bynow.rei.core.exception.ReiException;
import com.bynow.rei.core.log.LogObjectHolder;
import com.bynow.rei.core.util.ReiUtil;
import com.bynow.rei.core.util.ToolUtil;
import com.bynow.rei.modular.blog.model.Article;
import com.bynow.rei.modular.blog.service.IArticleService;
import com.bynow.rei.modular.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章管理控制器
 *
 * @author fengshuonan
 * @Date 2018-05-15 14:39:43
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {

    private String PREFIX = "/blog/article/";

    @Autowired
    private IArticleService articleService;
    @Autowired
    private ICategoryService categoryService;


    /**
     * 跳转到文章管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "article.html";
    }

    /**
     * 跳转到添加文章管理
     */
    @RequestMapping("/article_add")
    public String articleAdd(Model model){
        model.addAttribute("catList",categoryService.getKeyValue(ReiUtil.getInstance().getCurrentUserId()));
        return PREFIX + "article_add.html";
    }

    /**
     * 跳转到修改文章管理
     */
    @RequestMapping("/article_update/{articleId}")
    public String articleUpdate(@PathVariable Integer articleId, Model model) {
        Article article = articleService.selectById(articleId);
        article.setDetail(HtmlUtils.htmlUnescape(article.getDetail()));
        model.addAttribute("item",article);
        model.addAttribute("catList",categoryService.getKeyValue(ReiUtil.getInstance().getCurrentUserId()));
        LogObjectHolder.me().set(article);
        return PREFIX + "article_edit.html";
    }

    /**
     * 获取文章管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        if (ReiUtil.getInstance().checkUserIsAdmin())
            return articleService.selectList(null);
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",ReiUtil.getInstance().getCurrentUserId());
        return articleService.selectByMap(map);
    }

    /**
     * 新增文章管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Article article) {
        if (ToolUtil.isOneEmpty(article)) {
            throw new ReiException(BizExceptionEnum.REQUEST_NULL);
        }
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        article.setUserId(ReiUtil.getInstance().getCurrentUserId());
        articleService.insert(article);
        return SUCCESS_TIP;
    }

    /**
     * 删除文章管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer articleId) {
        articleService.deleteById(articleId);
        return SUCCESS_TIP;
    }

    /**
     * 修改文章管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Article article) {
        articleService.updateById(article);
        return SUCCESS_TIP;
    }

    /**
     * 文章管理详情
     */
    @RequestMapping(value = "/detail/{articleId}")
    @ResponseBody
    public Object detail(@PathVariable("articleId") Integer articleId) {
        return articleService.selectById(articleId);
    }
}
