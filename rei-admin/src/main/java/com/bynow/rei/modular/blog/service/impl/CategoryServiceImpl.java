package com.bynow.rei.modular.blog.service.impl;

import com.bynow.rei.modular.blog.model.Category;
import com.bynow.rei.modular.blog.dao.CategoryMapper;
import com.bynow.rei.modular.blog.service.ICategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客类别表 服务实现类
 * </p>
 *
 * @author bynow123
 * @since 2018-05-15
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
