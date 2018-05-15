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
import com.bynow.rei.modular.blog.model.Article;
import com.bynow.rei.modular.blog.service.IArticleService;

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
    public String articleAdd() {
        return PREFIX + "article_add.html";
    }

    /**
     * 跳转到修改文章管理
     */
    @RequestMapping("/article_update/{articleId}")
    public String articleUpdate(@PathVariable Integer articleId, Model model) {
        Article article = articleService.selectById(articleId);
        model.addAttribute("item",article);
        LogObjectHolder.me().set(article);
        return PREFIX + "article_edit.html";
    }

    /**
     * 获取文章管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return articleService.selectList(null);
    }

    /**
     * 新增文章管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Article article) {
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
