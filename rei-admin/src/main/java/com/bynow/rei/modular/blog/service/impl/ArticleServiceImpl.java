package com.bynow.rei.modular.blog.service.impl;

import com.bynow.rei.modular.blog.model.Article;
import com.bynow.rei.modular.blog.dao.ArticleMapper;
import com.bynow.rei.modular.blog.service.IArticleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客文章表 服务实现类
 * </p>
 *
 * @author bynow123
 * @since 2018-05-15
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
