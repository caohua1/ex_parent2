package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ShareOrder {
    private Long id;

    private String ordernum;

    private Long buyuserid;

    private Long shareuserid;

    private String shareusername;

    private String buyusername;

    private String sharemechanism;

    private Double commission;

    private String merchantname;

    private Double ordermoney;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatetime;

    private Integer paystatus;

    private Integer status;

    private Orders orders;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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

    public Long getBuyuserid() {
        return buyuserid;
    }

    public void setBuyuserid(Long buyuserid) {
        this.buyuserid = buyuserid;
    }

    public Long getShareuserid() {
        return shareuserid;
    }

    public void setShareuserid(Long shareuserid) {
        this.shareuserid = shareuserid;
    }

    public String getShareusername() {
        return shareusername;
    }

    public void setShareusername(String shareusername) {
        this.shareusername = shareusername;
    }

    public String getBuyusername() {
        return buyusername;
    }

    public void setBuyusername(String buyusername) {
        this.buyusername = buyusername;
    }

    public String getSharemechanism() {
        return sharemechanism;
    }

    public void setSharemechanism(String sharemechanism) {
        this.sharemechanism = sharemechanism;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public Double getOrdermoney() {
        return ordermoney;
    }

    public void setOrdermoney(Double ordermoney) {
        this.ordermoney = ordermoney;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}