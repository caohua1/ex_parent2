package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ProductInfoManage implements Serializable {

    private Long id;
    private Long merchantId;//商家id
    private String productName;//商品名称
    private Long productClassifyId;//商品分类
    private Double agentPrice;//商品的代理价
    private Double vipPrice;//会员价
    private Double resalePrice;//零售价
    private Integer storeNum;//商品库存
    private Integer storePrewarnNum;//库存预警值
    private Long brandId;//品牌（与brand主键关联）
    private String productPicUrl;//商品图
    private String appSlideshowPic;//app端轮播图
    private String pcSlideshowPic;//pc端轮播图
    private String productDescribe;//商品详情
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private Integer shareSet;//分享设置（0（1+2分享模式）1按比例返利模式 ）
    private Integer saleOrderNum;//出售订单数量
    private Integer SHStatus;//审核状态（0待审核 1审核失败 2审核成功）
    private Integer SXJStatus;//上下架状态（0下架 1上架）
    private Integer DLStatus;//代理状态（0不可代理 1可代理）
    private Integer STJStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductClassifyId() {
        return productClassifyId;
    }

    public void setProductClassifyId(Long productClassifyId) {
        this.productClassifyId = productClassifyId;
    }

    public Double getAgentPrice() {
        return agentPrice;
    }

    public void setAgentPrice(Double agentPrice) {
        this.agentPrice = agentPrice;
    }

    public Double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(Double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public Double getResalePrice() {
        return resalePrice;
    }

    public void setResalePrice(Double resalePrice) {
        this.resalePrice = resalePrice;
    }

    public Integer getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(Integer storeNum) {
        this.storeNum = storeNum;
    }

    public Integer getStorePrewarnNum() {
        return storePrewarnNum;
    }

    public void setStorePrewarnNum(Integer storePrewarnNum) {
        this.storePrewarnNum = storePrewarnNum;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getProductPicUrl() {
        return productPicUrl;
    }

    public void setProductPicUrl(String productPicUrl) {
        this.productPicUrl = productPicUrl;
    }

    public String getAppSlideshowPic() {
        return appSlideshowPic;
    }

    public void setAppSlideshowPic(String appSlideshowPic) {
        this.appSlideshowPic = appSlideshowPic;
    }

    public String getPcSlideshowPic() {
        return pcSlideshowPic;
    }

    public void setPcSlideshowPic(String pcSlideshowPic) {
        this.pcSlideshowPic = pcSlideshowPic;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getShareSet() {
        return shareSet;
    }

    public void setShareSet(Integer shareSet) {
        this.shareSet = shareSet;
    }

    public Integer getSaleOrderNum() {
        return saleOrderNum;
    }

    public void setSaleOrderNum(Integer saleOrderNum) {
        this.saleOrderNum = saleOrderNum;
    }

    public Integer getSHStatus() {
        return SHStatus;
    }

    public void setSHStatus(Integer SHStatus) {
        this.SHStatus = SHStatus;
    }

    public Integer getSXJStatus() {
        return SXJStatus;
    }

    public void setSXJStatus(Integer SXJStatus) {
        this.SXJStatus = SXJStatus;
    }

    public Integer getDLStatus() {
        return DLStatus;
    }

    public void setDLStatus(Integer DLStatus) {
        this.DLStatus = DLStatus;
    }

    public Integer getSTJStatus() {
        return STJStatus;
    }

    public void setSTJStatus(Integer STJStatus) {
        this.STJStatus = STJStatus;
    }
}
