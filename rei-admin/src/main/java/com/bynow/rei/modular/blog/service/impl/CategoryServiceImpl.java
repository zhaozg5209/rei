package com.bynow.rei.modular.blog.service.impl;

import com.baomidou.mybatisplus.mapper.SqlRunner;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bynow.rei.modular.blog.dao.CategoryMapper;
import com.bynow.rei.modular.blog.model.Category;
import com.bynow.rei.modular.blog.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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


    @Override
    public List<Map<String, Object>> getKeyValue(Integer userId) {
        String sql = "select id AS value,`name` AS `key`  from blog_category where user_id="+userId;
        return  SqlRunner.db().selectList(sql);
    }
}
