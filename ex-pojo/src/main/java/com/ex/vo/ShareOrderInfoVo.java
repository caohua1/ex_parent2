package com.ex.vo;

import java.io.Serializable;

public class ShareOrderInfoVo implements Serializable {
    private Double total;//总计
    private Double waitRevenue;//待收益
    private Integer completeOrder;//完成订单
    private Integer orderInTransaction;//交易中订单

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
}
