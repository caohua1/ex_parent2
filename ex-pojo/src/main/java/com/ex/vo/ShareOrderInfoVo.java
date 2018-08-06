package com.ex.vo;

import com.ex.entity.ShareOrder;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ShareOrderInfoVo extends ShareOrder implements Serializable {
    private Double total;//总计
    private Double waitRevenue;//待收益
    private Integer completeOrder;//完成订单
    private Integer orderInTransaction;//交易中订单
    private Integer shareOrderStatus;
    private String username;//商家账号
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getWaitRevenue() {
        return waitRevenue;
    }

    public void setWaitRevenue(Double waitRevenue) {
        this.waitRevenue = waitRevenue;
    }

    public Integer getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(Integer completeOrder) {
        this.completeOrder = completeOrder;
    }

    public Integer getOrderInTransaction() {
        return orderInTransaction;
    }

    public void setOrderInTransaction(Integer orderInTransaction) {
        this.orderInTransaction = orderInTransaction;
    }

    public Integer getShareOrderStatus() {
        return shareOrderStatus;
    }

    public void setShareOrderStatus(Integer shareOrderStatus) {
        this.shareOrderStatus = shareOrderStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
}
