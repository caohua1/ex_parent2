package com.ex.vo;

import com.ex.entity.Orders;

import java.io.Serializable;
import java.util.Date;

public class PCOrderVo extends Orders implements Serializable {
    private String username;//商家账号
    private String registUserName;//用户账号
    private String storeName;//d店铺名称
    private Date startTime;
    private Date endTime;
    private ProductInfoManageVo productInfoManageVo; //订单的商品
    private Long merchantId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegistUserName() {
        return registUserName;
    }

    public void setRegistUserName(String registUserName) {
        this.registUserName = registUserName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public ProductInfoManageVo getProductInfoManageVo() {
        return productInfoManageVo;
    }

    public void setProductInfoManageVo(ProductInfoManageVo productInfoManageVo) {
        this.productInfoManageVo = productInfoManageVo;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
}
