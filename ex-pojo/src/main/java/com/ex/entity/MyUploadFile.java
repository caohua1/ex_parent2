package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户App上传文件实体类
 */
@Data
public class MyUploadFile implements Serializable {

    private Long id;
    private Long registUserId;//用户id（与userapp_regist主键关联）
    private String fileUrl;//文件保存路径
    private Long musicId;//背景音乐id
    private String describe;//描述（说说）
    private String link;//设置链接
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//修改时间
    private int status;//状态（0删除 1存在）





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegistUserId() {
        return registUserId;
    }

    public void setRegistUserId(Long registUserId) {
        this.registUserId = registUserId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Long getMusicId() {
        return musicId;
    }

    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public MyUploadFile() {
    }

    public MyUploadFile(Long id, Long registUserId, String fileUrl, Long musicId, String describe, String link, Date createTime, Date updateTime, int status) {
        this.id = id;
        this.registUserId = registUserId;
        this.fileUrl = fileUrl;
        this.musicId = musicId;
        this.describe = describe;
        this.link = link;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }
}
