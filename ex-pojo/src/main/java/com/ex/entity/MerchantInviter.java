package com.ex.entity;

import java.io.Serializable;
import java.util.Date;

public class MerchantInviter implements Serializable{
    private Long inviterCode;

    private Long inviterMerchantId;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    public Long getInviterCode() {
        return inviterCode;
    }

    public void setInviterCode(Long inviterCode) {
        this.inviterCode = inviterCode;
    }

    public Long getInviterMerchantId() {
        return inviterMerchantId;
    }

    public void setInviterMerchantId(Long inviterMerchantId) {
        this.inviterMerchantId = inviterMerchantId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}