package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class AppointmentOrder implements Serializable{

    private Long id;//主键
    private Long registUserId;//用户id
    private Long merchantId;//商家id
    private String productInfoIds;//商品ids,以分号隔开
    private String registUsername;//用户账号
    private String contactsName;//联系人姓名
    private String contactsPhone;//联系人电话
    private String orderNum;//订单编号
    private Integer peopleNum;//预约人数
    private String merchantName;//商家名称
    private String productName;//商品名称
    private Double appointmentMoney;//预约金额
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date appointmentTime;//预约时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间（提交时间）
    private String remark;//备注（可填写需求）
    private Integer payWay;//支付方式（0微信支付 1支付宝支付）
    private Integer payStatus;//支付状态（ 1待支付 2已支付）
    private Integer status;//状态
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//修改时间

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

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
