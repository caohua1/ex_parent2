package com.ex.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 视享竞价排名实体类
 */
public class PaidlistProduct implements Serializable {
    private Long id;
    private String orderNumber;
    private Long merchantId;
    private Long uploadProductId;
    private int type;
    private Double money;
    private int payWay;
    private Date createTime;
    private Date updateTime;
    private String order;
    private String state;

    public PaidlistProduct(Long id,String orderNumber,Long merchantId, Long uploadProductId, int type, double money, int payWay, Date createTime, Date updateTime, String order, int remainingTime,String state) {
        this.id = id;
        this.orderNumber=orderNumber;
        this.merchantId = merchantId;
        this.uploadProductId = uploadProductId;
        this.type = type;
        this.money = money;
        this.payWay = payWay;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.order = order;
        this.state=state;

    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public PaidlistProduct() {
        super();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getUploadProductId() {
        return uploadProductId;
    }

    public void setUploadProductId(Long uploadProductId) {
        this.uploadProductId = uploadProductId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getPayWay() {
        return payWay;
    }

    public void setPayWay(int payWay) {
        this.payWay = payWay;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }


}
