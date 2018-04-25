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
@TableName("bynow_blog_banner")
public class BlogBanner extends Model<BlogBanner> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private Integer userId;
    /**
     * banner图片地址
     */
    @TableField("banner_image_url")
    private String bannerImageUrl;
    /**
     * 排序id
     */
    @TableField("banner_order_id")
    private Integer bannerOrderId;
    /**
     * 是否显示
     */
    @TableField("banner_on_show")
    private Integer bannerOnShow;


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

    public String getBannerImageUrl() {
        return bannerImageUrl;
    }

    public void setBannerImageUrl(String bannerImageUrl) {
        this.bannerImageUrl = bannerImageUrl;
    }

    public Integer getBannerOrderId() {
        return bannerOrderId;
    }

    public void setBannerOrderId(Integer bannerOrderId) {
        this.bannerOrderId = bannerOrderId;
    }

    public Integer getBannerOnShow() {
        return bannerOnShow;
    }

    public void setBannerOnShow(Integer bannerOnShow) {
        this.bannerOnShow = bannerOnShow;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BlogBanner{" +
        "id=" + id +
        ", userId=" + userId +
        ", bannerImageUrl=" + bannerImageUrl +
        ", bannerOrderId=" + bannerOrderId +
        ", bannerOnShow=" + bannerOnShow +
        "}";
    }
}
