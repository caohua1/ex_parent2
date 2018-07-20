package com.ex.vo;

import com.ex.entity.MerchantorpersonCheckIn;

import java.io.Serializable;

public class MerchantCheckInVo extends MerchantorpersonCheckIn implements Serializable {

    private String industryName;//行业名称
    private String username;//商家账号

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
