package com.ex.vo;

import java.io.Serializable;

public class AgentMerchantVo implements Serializable{
    private Long merchantId;//商家ID
    private Long agenUserId;//代理人id
    private String storeName;//店铺名称
    private String advertisingPicUrl;//广告图片路径
    private String typeName;//商品类型

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getAgenUserId() {
        return agenUserId;
    }

    public void setAgenUserId(Long agenUserId) {
        this.agenUserId = agenUserId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAdvertisingPicUrl() {
        return advertisingPicUrl;
    }

    public void setAdvertisingPicUrl(String advertisingPicUrl) {
        this.advertisingPicUrl = advertisingPicUrl;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
