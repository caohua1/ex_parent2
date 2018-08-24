package com.ex.vo;

import java.io.Serializable;

public class UserMoneyVo implements Serializable{

    private Long registUserId;//用户id
    private String username;//用户账号
    private Double YuE;//用户可用金额
    private Double TQMoney;//提取中的金额

    public Long getRegistUserId() {
        return registUserId;
    }

    public void setRegistUserId(Long registUserId) {
        this.registUserId = registUserId;
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
}
