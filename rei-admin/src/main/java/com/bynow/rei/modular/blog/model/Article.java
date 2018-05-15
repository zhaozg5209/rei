package com.bynow.rei.modular.blog.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 博客文章表
 * </p>
 *
 * @author bynow123
 * @since 2018-05-15
 */
@TableName("blog_article")
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 类别id
     */
    @TableField("category_id")
    private Integer categoryId;
    /**
     * 作者
     */
    private String author;
    /**
     * 文章名
     */
    private String title;
    /**
     * 转载链接
     */
    @TableField("copy_from")
    private String copyFrom;
    /**
     * 简单描述
     */
    @TableField("simple_desc")
    private String simpleDesc;
    /**
     * banner图链接
     */
    @TableField("banner_url")
    private String bannerUrl;
    /**
     * 关键字  标签
     */
    private String keywords;
    /**
     * 内容
     */
    private String detail;
    /**
     * 是否展示
     */
    @TableField("on_show")
    private Integer onShow;
    /**
     * 点击数
     */
    private Integer hits;
    /**
     * 评论数
     */
    @TableField("post_num")
    private Integer postNum;
    /**
     * 原创1;转载0
     */
    @TableField("create_status")
    private Integer createStatus;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCopyFrom() {
        return copyFrom;
    }

    public void setCopyFrom(String copyFrom) {
        this.copyFrom = copyFrom;
    }

    public String getSimpleDesc() {
        return simpleDesc;
    }

    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getPostNum() {
        return postNum;
    }

    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }

    public Integer getCreateStatus() {
        return createStatus;
    }

    public void setCreateStatus(Integer createStatus) {
        this.createStatus = createStatus;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Article{" +
        "id=" + id +
        ", userId=" + userId +
        ", categoryId=" + categoryId +
        ", author=" + author +
        ", title=" + title +
        ", copyFrom=" + copyFrom +
        ", simpleDesc=" + simpleDesc +
        ", bannerUrl=" + bannerUrl +
        ", keywords=" + keywords +
        ", detail=" + detail +
        ", onShow=" + onShow +
        ", hits=" + hits +
        ", postNum=" + postNum +
        ", createStatus=" + createStatus +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
