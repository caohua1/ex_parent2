package com.ex.vo;

import com.ex.entity.MerchantPersonData;

import java.io.Serializable;

public class MerchantPersonDataVo extends MerchantPersonData implements Serializable {

    private Long inviterCode;//推广码（邀请码）
    private String companyName;//企业名称

    public Long getInviterCode() {
        return inviterCode;
    }

    public void setInviterCode(Long inviterCode) {
        this.inviterCode = inviterCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
