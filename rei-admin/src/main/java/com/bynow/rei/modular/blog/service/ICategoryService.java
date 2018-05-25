package com.bynow.rei.modular.blog.service;

import com.bynow.rei.modular.blog.model.Category;
import com.baomidou.mybatisplus.service.IService;

import javax.management.ObjectName;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客类别表 服务类
 * </p>
 *
 * @author bynow
 * @since 2018-05-15
 */
public interface ICategoryService extends IService<Category> {
        List<Map<String,Object>> getKeyValue(Integer userId);
}
