package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.io.Serializable;
import java.util.Date;

/**
 * 视图管理（视图配置）实体类
 */

public class ViewManage implements Serializable {
    public Long id;
    public Integer videoTime;
    public Integer fileKb;
    public Integer bidTime;
    public Integer videoInitialize;
    public Integer pictureInitialize;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date updateTime;
    public Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Integer videoTime) {
        this.videoTime = videoTime;
    }

    public Integer getFileKb() {
        return fileKb;
    }

    public void setFileKb(Integer fileKb) {
        this.fileKb = fileKb;
    }

    public Integer getBidTime() {
        return bidTime;
    }

    public void setBidTime(Integer bidTime) {
        this.bidTime = bidTime;
    }

    public Integer getVideoInitialize() {
        return videoInitialize;
    }

    public void setVideoInitialize(Integer videoInitialize) {
        this.videoInitialize = videoInitialize;
    }

    public Integer getPictureInitialize() {
        return pictureInitialize;
    }

    public void setPictureInitialize(Integer pictureInitialize) {
        this.pictureInitialize = pictureInitialize;
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