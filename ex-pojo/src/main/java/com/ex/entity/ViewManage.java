package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 视图管理（视图配置）实体类
 */
@Data
public class ViewManage {
    public Long id;
    public int videoTime;
    public int fileKb;
    public int bidTime;
    public int videoInitialize;
    public int pictureInitialize;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date updateTime;
    public int status;

    public int getStatus() {
        return status;
    }

    public ViewManage(int status) {
        this.status = status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ViewManage(Long id, int videoTime, int fileKb, int bidTime, int videoInitialize, int pictureInitialize, Date createTime, Date updateTime) {
        this.id = id;
        this.videoTime = videoTime;
        this.fileKb = fileKb;
        this.bidTime = bidTime;
        this.videoInitialize = videoInitialize;

        this.pictureInitialize = pictureInitialize;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ViewManage() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(int videoTime) {
        this.videoTime = videoTime;
    }

    public int getFileKb() {
        return fileKb;
    }

    public void setFileKb(int fileKb) {
        this.fileKb = fileKb;
    }

    public int getBidTime() {
        return bidTime;
    }

    public void setBidTime(int bidTime) {
        this.bidTime = bidTime;
    }

    public int getVideoInitialize() {
        return videoInitialize;
    }

    public void setVideoInitialize(int videoInitialize) {
        this.videoInitialize = videoInitialize;
    }

    public int getPictureInitialize() {
        return pictureInitialize;
    }

    public void setPictureInitialize(int pictureInitialize) {
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
}
