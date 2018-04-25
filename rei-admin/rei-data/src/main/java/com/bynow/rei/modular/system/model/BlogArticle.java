package com.bynow.rei.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
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
@TableName("bynow_blog_article")
public class BlogArticle extends Model<BlogArticle> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章详情表自增长id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 关联用户表id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 类别表id
     */
    @TableField("category_id")
    private Integer categoryId;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 描述
     */
    private String desc;
    private String author;
    /**
     * 创建日期
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改日期
     */
    @TableField("update_time")
    private Date updateTime;
    private String images;
    private String detail;
    /**
     * 是否展示
     */
    @TableField("on_show")
    private Integer onShow;


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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getOnShow() {
        return onShow;
    }

    public void setOnShow(Integer onShow) {
        this.onShow = onShow;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BlogArticle{" +
        "id=" + id +
        ", userId=" + userId +
        ", categoryId=" + categoryId +
        ", title=" + title +
        ", desc=" + desc +
        ", author=" + author +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", images=" + images +
        ", detail=" + detail +
        ", onShow=" + onShow +
        "}";
    }
}
