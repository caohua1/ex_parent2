package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 关注表
 */
public class Care implements Serializable {
    private Long  id;//主键
    private Long careUserId;//关注人的id
    private Long beCareUserId;//被关注的人id
    private Integer type;//标注（1普通用户 2商家）
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//关注时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//修改时间
    private Integer status;//状态（0取消关注 1关注）

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCareUserId() {
        return careUserId;
    }

    public void setCareUserId(Long careUserId) {
        this.careUserId = careUserId;
    }

    public Long getBeCareUserId() {
        return beCareUserId;
    }

    public void setBeCareUserId(Long beCareUserId) {
        this.beCareUserId = beCareUserId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
