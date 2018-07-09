package com.ex.entity;

import java.util.Date;

public class Orders {
    private Long id;

    private String ordernum;

    private Integer productnum;

    private Double ordermoney;

    private Long productinfoid;

    private Long addressid;

    private Date createtime;

    private Date paytime;

    private Date sendtime;

    private Date finishtime;

    private Double money;

    private Integer paystatus;

    private String backcauseby;

    private String backnum;

    private Integer status;

    private ProductInfoManage productInfoManage;

    public ProductInfoManage getProductInfoManage() {
        return productInfoManage;
    }

    public void setProductInfoManage(ProductInfoManage productInfoManage) {
        this.productInfoManage = productInfoManage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public Integer getProductnum() {
        return productnum;
    }

    public void setProductnum(Integer productnum) {
        this.productnum = productnum;
    }

    public Double getOrdermoney() {
        return ordermoney;
    }

    public void setOrdermoney(Double ordermoney) {
        this.ordermoney = ordermoney;
    }

    public Long getProductinfoid() {
        return productinfoid;
    }

    public void setProductinfoid(Long productinfoid) {
        this.productinfoid = productinfoid;
    }

    public Long getAddressid() {
        return addressid;
    }

    public void setAddressid(Long addressid) {
        this.addressid = addressid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public String getBackcauseby() {
        return backcauseby;
    }

    public void setBackcauseby(String backcauseby) {
        this.backcauseby = backcauseby;
    }

    public String getBacknum() {
        return backnum;
    }

    public void setBacknum(String backnum) {
        this.backnum = backnum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}