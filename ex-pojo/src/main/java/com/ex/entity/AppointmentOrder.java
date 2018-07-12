package com.ex.entity;

import java.io.Serializable;
import java.util.Date;

public class AppointmentOrder implements Serializable{

    private Long id;
    private Long registUserId;
    private String productInfoIds;
    private String registUsername;
    private String contactsName;
    private String contactsPhone;
    private String orderNum;
    private Integer peopleNum;
    private String merchantName;
    private String productName;
    private Double appointmentMoney;
    private Date appointmentTime;
    private Date createTime;
    private String remark;
    private Integer payWay;
    private Integer payStatus;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegistUserId() {
        return registUserId;
    }

    public void setRegistUserId(Long registUserId) {
        this.registUserId = registUserId;
    }

    public String getProductInfoIds() {
        return productInfoIds;
    }

    public void setProductInfoIds(String productInfoIds) {
        this.productInfoIds = productInfoIds;
    }

    public String getRegistUsername() {
        return registUsername;
    }

    public void setRegistUsername(String registUsername) {
        this.registUsername = registUsername;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getAppointmentMoney() {
        return appointmentMoney;
    }

    public void setAppointmentMoney(Double appointmentMoney) {
        this.appointmentMoney = appointmentMoney;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
