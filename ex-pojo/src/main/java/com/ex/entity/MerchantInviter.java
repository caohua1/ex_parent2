package com.ex.entity;

import java.util.Date;

public class MerchantInviter {
    private Long invitercode;

    private Long invitermerchantid;

    private Date createtime;

    private Date updatetime;

    private Integer status;

    public Long getInvitercode() {
        return invitercode;
    }

    public void setInvitercode(Long invitercode) {
        this.invitercode = invitercode;
    }

    public Long getInvitermerchantid() {
        return invitermerchantid;
    }

    public void setInvitermerchantid(Long invitermerchantid) {
        this.invitermerchantid = invitermerchantid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}