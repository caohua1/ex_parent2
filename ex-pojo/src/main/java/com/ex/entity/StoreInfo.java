package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class StoreInfo implements Serializable {
    private Long id;

    private Long productclassifyid;

    private Long merchantid;

    private Double YuE;//商家的余额

    private String storename;

    private String describe;

    private String advertisingpicurl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatetime;

    private Integer status;

    private Integer paystatus;

    private Integer STJStatus;
    private Integer isAppointment;//是否可预订

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductclassifyid() {
        return productclassifyid;
    }

    public void setProductclassifyid(Long productclassifyid) {
        this.productclassifyid = productclassifyid;
    }

    public Long getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Long merchantid) {
        this.merchantid = merchantid;
    }

    public Double getYuE() {
        return YuE;
    }

    public void setYuE(Double yuE) {
        YuE = yuE;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getAdvertisingpicurl() {
        return advertisingpicurl;
    }

    public void setAdvertisingpicurl(String advertisingpicurl) {
        this.advertisingpicurl = advertisingpicurl;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public Integer getSTJStatus() {
        return STJStatus;
    }

    public void setSTJStatus(Integer STJStatus) {
        this.STJStatus = STJStatus;
    }

    public Integer getIsAppointment() {
        return isAppointment;
    }

    public void setIsAppointment(Integer isAppointment) {
        this.isAppointment = isAppointment;
    }
}