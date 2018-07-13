package com.ex.entity;

import java.util.Date;

public class MerchantElect {
    private Long id;//主键
    private Long merchantId;//互推商家id（与merchant_regist主键关联）
    private Long BeMerchantId;//被互推的商家id
    private Double commissionRate;//佣金比例
    private int electMerchantStatus;//互推商家状态（0待确认 1互推同意 2不同意互推 3取消互推）
    private int BeElectMerchanStatus;//被互推的商家的状态（0待确认 1同意互推 2不同意互推 3取消互推）
    private Date createTime;//创建时间

    public MerchantElect(Long id, Long merchantId, Long beMerchantId, Double commissionRate, int electMerchantStatus, int beElectMerchanStatus, Date createTime) {
        this.id = id;
        this.merchantId = merchantId;
        BeMerchantId = beMerchantId;
        this.commissionRate = commissionRate;
        this.electMerchantStatus = electMerchantStatus;
        BeElectMerchanStatus = beElectMerchanStatus;
        this.createTime = createTime;
    }

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

    public Long getBeMerchantId() {
        return BeMerchantId;
    }

    public void setBeMerchantId(Long beMerchantId) {
        BeMerchantId = beMerchantId;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public int getElectMerchantStatus() {
        return electMerchantStatus;
    }

    public void setElectMerchantStatus(int electMerchantStatus) {
        this.electMerchantStatus = electMerchantStatus;
    }

    public int getBeElectMerchanStatus() {
        return BeElectMerchanStatus;
    }

    public void setBeElectMerchanStatus(int beElectMerchanStatus) {
        BeElectMerchanStatus = beElectMerchanStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}