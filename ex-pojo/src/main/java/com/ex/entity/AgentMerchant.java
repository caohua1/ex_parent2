package com.ex.entity;

import java.util.Date;

public class AgentMerchant {
    private Long id;

    private Long agentuserid;

    private Long merchantid;

    private Long productinfoid;

    private Date agenttime;

    private Date updatetime;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgentuserid() {
        return agentuserid;
    }

    public void setAgentuserid(Long agentuserid) {
        this.agentuserid = agentuserid;
    }

    public Long getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Long merchantid) {
        this.merchantid = merchantid;
    }

    public Long getProductinfoid() {
        return productinfoid;
    }

    public void setProductinfoid(Long productinfoid) {
        this.productinfoid = productinfoid;
    }

    public Date getAgenttime() {
        return agenttime;
    }

    public void setAgenttime(Date agenttime) {
        this.agenttime = agenttime;
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