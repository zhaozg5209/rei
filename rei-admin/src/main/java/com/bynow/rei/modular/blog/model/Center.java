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
 * 博客个人中心
 * </p>
 *
 * @author bynow123
 * @since 2018-05-15
 */
@TableName("blog_center")
public class Center extends Model<Center> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 座右铭
     */
    private String motto;
    /**
     * 出生年月
     */
    private Date birthday;
    /**
     * 工作年限
     */
    @TableField("work_years")
    private Integer workYears;
    /**
     * 居住地
     */
    private String address;
    /**
     * 公司
     */
    private String company;
    /**
     * 行业
     */
    private String industry;
    /**
     * 职业简介
     */
    @TableField("simple_desc")
    private String simpleDesc;
    /**
     * 详细介绍
     */
    private String detail;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getWorkYears() {
        return workYears;
    }

    public void setWorkYears(Integer workYears) {
        this.workYears = workYears;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSimpleDesc() {
        return simpleDesc;
    }

    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc;
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
        return "Center{" +
        "id=" + id +
        ", motto=" + motto +
        ", birthday=" + birthday +
        ", workYears=" + workYears +
        ", address=" + address +
        ", company=" + company +
        ", industry=" + industry +
        ", simpleDesc=" + simpleDesc +
        ", detail=" + detail +
        "}";
    }
}
