package com.bynow.rei.modular.blog.controller;

import com.bynow.rei.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.bynow.rei.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.bynow.rei.modular.blog.model.Center;
import com.bynow.rei.modular.blog.service.ICenterService;

/**
 * 博客管理控制器
 *
 * @author fengshuonan
 * @Date 2018-05-15 13:59:32
 */
@Controller
@RequestMapping("/center")
public class CenterController extends BaseController {

    private String PREFIX = "/blog/center/";

    @Autowired
    private ICenterService centerService;

    /**
     * 跳转到博客管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "center.html";
    }

    /**
     * 跳转到添加博客管理
     */
    @RequestMapping("/center_add")
    public String centerAdd() {
        return PREFIX + "center_add.html";
    }

    /**
     * 跳转到修改博客管理
     */
    @RequestMapping("/center_update/{centerId}")
    public String centerUpdate(@PathVariable Integer centerId, Model model) {
        Center center = centerService.selectById(centerId);
        model.addAttribute("item",center);
        LogObjectHolder.me().set(center);
        return PREFIX + "center_edit.html";
    }

    /**
     * 获取博客管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return centerService.selectList(null);
    }

    /**
     * 新增博客管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Center center) {
        centerService.insert(center);
        return SUCCESS_TIP;
    }

    /**
     * 删除博客管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer centerId) {
        centerService.deleteById(centerId);
        return SUCCESS_TIP;
    }

    /**
     * 修改博客管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Center center) {
        centerService.updateById(center);
        return SUCCESS_TIP;
    }

    /**
     * 博客管理详情
     */
    @RequestMapping(value = "/detail/{centerId}")
    @ResponseBody
    public Object detail(@PathVariable("centerId") Integer centerId) {
        return centerService.selectById(centerId);
    }
}
