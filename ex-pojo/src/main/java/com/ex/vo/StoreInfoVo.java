package com.ex.vo;

import com.ex.entity.StoreInfo;

import java.io.Serializable;

public class StoreInfoVo extends StoreInfo implements Serializable {

    private Double merchantDiscussAvg;//商家的平均评论分数
    private Integer ordersNums;//总销售单数

    public Double getMerchantDiscussAvg() {
        return merchantDiscussAvg;
    }

    public void setMerchantDiscussAvg(Double merchantDiscussAvg) {
        this.merchantDiscussAvg = merchantDiscussAvg;
    }

    public Integer getOrdersNums() {
        return ordersNums;
    }

    public void setOrdersNums(Integer ordersNums) {
        this.ordersNums = ordersNums;
    }
}
