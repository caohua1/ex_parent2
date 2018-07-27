package com.ex.vo;

import com.ex.entity.AgentMerchant;

/**
 * 可代理商品
 */
public class AgentMerchantProductinfoVo extends AgentMerchant {

    private String productName;//商品名称
    private String productPicUrl;//商品图
    private Double resalePrice;//零售价
    private Double vipPrice;//会员价

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPicUrl() {
        return productPicUrl;
    }

    public void setProductPicUrl(String productPicUrl) {
        this.productPicUrl = productPicUrl;
    }

    public Double getResalePrice() {
        return resalePrice;
    }

    public void setResalePrice(Double resalePrice) {
        this.resalePrice = resalePrice;
    }

    public Double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(Double vipPrice) {
        this.vipPrice = vipPrice;
    }
}
