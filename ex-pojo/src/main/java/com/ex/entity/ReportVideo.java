package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 举报视频实体类
 */
@Data
public class ReportVideo implements Serializable {

    private Long id;
    private Long uploadFileId;//被举报的视频/图片id（与merchantorperson_upload_product主键关联）
    private Long registUserId;//举报人的id（与userapp_regist主键关联）
    private String picUrl;//举报图片路径
    private String causeBy;//举报理由
    private String describe;//举报描述
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//举报时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//修改时间
    private int status;//状态（0举报，未处理 1处理举报结果）

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUploadFileId() {
        return uploadFileId;
    }

    public void setUploadFileId(Long uploadFileId) {
        this.uploadFileId = uploadFileId;
    }

    public Long getRegistUserId() {
        return registUserId;
    }

    public void setRegistUserId(Long registUserId) {
        this.registUserId = registUserId;
    }

    public String getCauseBy() {
        return causeBy;
    }

    public void setCauseBy(String causeBy) {
        this.causeBy = causeBy;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ReportVideo() {
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public ReportVideo(Long id, Long uploadFileId, Long registUserId,String picUrl, String causeBy, String describe, Date createTime, Date updateTime, int status) {
        this.id = id;
        this.uploadFileId = uploadFileId;
        this.registUserId = registUserId;
        this.picUrl=picUrl;
        this.causeBy = causeBy;
        this.describe = describe;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReportVideo{" +
                "id=" + id +
                ", uploadFileId=" + uploadFileId +
                ", registUserId=" + registUserId +
                ", causeBy='" + causeBy + '\'' +
                ", describe='" + describe + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}
