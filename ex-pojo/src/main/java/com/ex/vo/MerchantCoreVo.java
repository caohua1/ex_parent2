package com.ex.vo;

import com.ex.entity.MerchantElect;

public class MerchantCoreVo extends MerchantElect {
    private String merchantUsername;
    private String BeMerchantUsername;

    public String getMerchantUsername() {
        return merchantUsername;
    }

    public void setMerchantUsername(String merchantUsername) {
        this.merchantUsername = merchantUsername;
    }

    public String getBeMerchantUsername() {
        return BeMerchantUsername;
    }

    public void setBeMerchantUsername(String beMerchantUsername) {
        BeMerchantUsername = beMerchantUsername;
    }
}
