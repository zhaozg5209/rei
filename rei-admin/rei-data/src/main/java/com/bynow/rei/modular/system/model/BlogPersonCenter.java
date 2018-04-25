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
@TableName("bynow_blog_person_center")
public class BlogPersonCenter extends Model<BlogPersonCenter> {

    private static final long serialVersionUID = 1L;

    /**
     * 个人中心自增长id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 关联用户表
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 座右铭
     */
    private String motto;
    private String company;
    /**
     * 地区
     */
    private String area;
    /**
     * 社交主页
     */
    @TableField("social_home_page")
    private String socialHomePage;
    /**
     * 个人详情
     */
    private String detail;


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

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSocialHomePage() {
        return socialHomePage;
    }

    public void setSocialHomePage(String socialHomePage) {
        this.socialHomePage = socialHomePage;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BlogPersonCenter{" +
        "id=" + id +
        ", userId=" + userId +
        ", motto=" + motto +
        ", company=" + company +
        ", area=" + area +
        ", socialHomePage=" + socialHomePage +
        ", detail=" + detail +
        "}";
    }
}
