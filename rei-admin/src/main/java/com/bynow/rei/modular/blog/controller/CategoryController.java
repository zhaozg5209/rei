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
import com.bynow.rei.modular.blog.model.Category;
import com.bynow.rei.modular.blog.service.ICategoryService;

/**
 * 博客类别控制器
 *
 * @author fengshuonan
 * @Date 2018-05-15 14:58:41
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

    private String PREFIX = "/blog/category/";

    @Autowired
    private ICategoryService categoryService;

    /**
     * 跳转到博客类别首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "category.html";
    }

    /**
     * 跳转到添加博客类别
     */
    @RequestMapping("/category_add")
    public String categoryAdd() {
        return PREFIX + "category_add.html";
    }

    /**
     * 跳转到修改博客类别
     */
    @RequestMapping("/category_update/{categoryId}")
    public String categoryUpdate(@PathVariable Integer categoryId, Model model) {
        Category category = categoryService.selectById(categoryId);
        model.addAttribute("item",category);
        LogObjectHolder.me().set(category);
        return PREFIX + "category_edit.html";
    }

    /**
     * 获取博客类别列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return categoryService.selectList(null);
    }

    /**
     * 新增博客类别
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Category category) {
        categoryService.insert(category);
        return SUCCESS_TIP;
    }

    /**
     * 删除博客类别
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer categoryId) {
        categoryService.deleteById(categoryId);
        return SUCCESS_TIP;
    }

    /**
     * 修改博客类别
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Category category) {
        categoryService.updateById(category);
        return SUCCESS_TIP;
    }

    /**
     * 博客类别详情
     */
    @RequestMapping(value = "/detail/{categoryId}")
    @ResponseBody
    public Object detail(@PathVariable("categoryId") Integer categoryId) {
        return categoryService.selectById(categoryId);
    }
}
