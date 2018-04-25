package com.bynow.rei.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author bynow123
 * @since 2018-04-05
 */
@TableName("bynow_blog_article_category")
public class BlogArticleCategory extends Model<BlogArticleCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章类别表自增长id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id，关联用户表
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 类别名称
     */
    @TableField("category_name")
    private String categoryName;
    /**
     * 类别图片地址
     */
    @TableField("category_image_url")
    private String categoryImageUrl;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BlogArticleCategory{" +
        "id=" + id +
        ", userId=" + userId +
        ", categoryName=" + categoryName +
        ", categoryImageUrl=" + categoryImageUrl +
        "}";
    }
}
