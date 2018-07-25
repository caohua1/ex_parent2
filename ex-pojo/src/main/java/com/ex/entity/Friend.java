package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Friend {
    private Long id;//主键
    private Long merchantId;//商家id（与merchant_regist主键关联）
    private Long friendId;//好友id（商家id）
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建好友关系的时间
    private Integer invitStatus;//邀请人状态（0待同意 1同意 ，已成为好友 2不同意 3取消好友）
    private Integer BeInvitStatus;//被邀请人的状态（0待接受 1同意，已成为好友 2不同意 3取消好友）

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

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getInvitStatus() {
        return invitStatus;
    }

    public void setInvitStatus(Integer invitStatus) {
        this.invitStatus = invitStatus;
    }

    public Integer getBeInvitStatus() {
        return BeInvitStatus;
    }

    public void setBeInvitStatus(Integer beInvitStatus) {
        BeInvitStatus = beInvitStatus;
    }
}
