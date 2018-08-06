package com.ex.vo;

import java.io.Serializable;

public class ShareOrderInfoPCVo implements Serializable {
    private int buyUserIds;//分享用户数总计
    private double orderMoneys;//订单总金额总计
    private double commissions;//佣金总计
    private int counts;//

    public int getBuyUserIds() {
        return buyUserIds;
    }

    public void setBuyUserIds(int buyUserIds) {
        this.buyUserIds = buyUserIds;
    }

    public double getOrderMoneys() {
        return orderMoneys;
    }

    public void setOrderMoneys(double orderMoneys) {
        this.orderMoneys = orderMoneys;
    }

    public double getCommissions() {
        return commissions;
    }

    public void setCommissions(double commissions) {
        this.commissions = commissions;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }
}
