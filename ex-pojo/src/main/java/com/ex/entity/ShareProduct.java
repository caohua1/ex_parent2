package com.ex.entity;

import com.ex.vo.ShareOrderVo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

//用户分享商品表（主表）
public class ShareProduct {
    private Long id;//主键
    private Long shareUserId;//分享用户id
    private Integer finishOrderNum;//此次1+2分享完成交易（完成订单数，最大2，最小0）
    private Double commissionMoney;//完成1+2模式后，返回的佣金金额
    private String shareMechanism;//分享机制（1+2模式/返利模式）'
    private Long productInfoId;//分享商品id
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;//创建时间
    private List<ShareOrderVo> shareOrderVos;

    public List<ShareOrderVo> getShareOrderVos() {
        return shareOrderVos;
    }

    public void setShareOrderVos(List<ShareOrderVo> shareOrderVos) {
        this.shareOrderVos = shareOrderVos;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(Long shareUserId) {
        this.shareUserId = shareUserId;
    }

    public Integer getFinishOrderNum() {
        return finishOrderNum;
    }

    public void setFinishOrderNum(Integer finishOrderNum) {
        this.finishOrderNum = finishOrderNum;
    }

    public Double getCommissionMoney() {
        return commissionMoney;
    }

    public void setCommissionMoney(Double commissionMoney) {
        this.commissionMoney = commissionMoney;
    }

    public String getShareMechanism() {
        return shareMechanism;
    }

    public void setShareMechanism(String shareMechanism) {
        this.shareMechanism = shareMechanism;
    }

    public Long getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }
}
