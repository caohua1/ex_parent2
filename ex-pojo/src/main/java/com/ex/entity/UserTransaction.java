package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class UserTransaction implements Serializable {
    private Long id;//主键
    private Long registUserId;//用户id
    private Double money;//交易金额
    private Integer type;//交易类型（0提现 1充值 2分享，得到的佣金）
    private String describes;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;//交易时间
    private Integer TXStatus;//提现状态
    private Integer status;//交易状态（0交易失败 1交易成功）

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
