package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class MerchantTransaction implements Serializable {

   private Long id;
   private Long merchantId;
   private Double money;
   private Integer type;
   private String describes;
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
   private Date createTime;
   private Integer TXStatus;//提现状态
   private Integer status;

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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescribe() {
        return describes;
    }

    public void setDescribe(String describe) {
        this.describes = describe;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTXStatus() {
        return TXStatus;
    }

    public void setTXStatus(Integer TXStatus) {
        this.TXStatus = TXStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
