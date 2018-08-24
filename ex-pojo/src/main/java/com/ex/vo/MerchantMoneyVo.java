package com.ex.vo;

import java.io.Serializable;

public class MerchantMoneyVo implements Serializable {
    private Long merchantId;//商家id
    private String username;//商家账号
    private Double YuE;//商家可用金额
    private Double TQMoney;//提取中的金额
    private Double DJMoney;//冻结金额（保护期金额）

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getYuE() {
        return YuE;
    }

    public void setYuE(Double yuE) {
        YuE = yuE;
    }

    public Double getTQMoney() {
        return TQMoney;
    }

    public void setTQMoney(Double TQMoney) {
        this.TQMoney = TQMoney;
    }

    public Double getDJMoney() {
        return DJMoney;
    }

    public void setDJMoney(Double DJMoney) {
        this.DJMoney = DJMoney;
    }
}
