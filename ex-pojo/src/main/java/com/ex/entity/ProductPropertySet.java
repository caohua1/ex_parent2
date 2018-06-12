package com.ex.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductPropertySet implements Serializable {

    private Long id;
    private Long productinfoId;
    private String typeName;//商品属性（颜色，尺寸）
    private String typeDescribe;//属性描述（颜色：红色）
    private Date appointmentTime;//如果有预约设置可设置预约时间
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductinfoId() {
        return productinfoId;
    }

    public void setProductinfoId(Long productinfoId) {
        this.productinfoId = productinfoId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescribe() {
        return typeDescribe;
    }

    public void setTypeDescribe(String typeDescribe) {
        this.typeDescribe = typeDescribe;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
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
}
