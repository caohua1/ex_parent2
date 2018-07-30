package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class IndustryAdvertising implements Serializable {

    /*CREATE TABLE `industry_advertising` (
            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
            `industryId` bigint(20) DEFAULT NULL COMMENT '所属行业的id',
            `advertiseName` varchar(500) DEFAULT NULL COMMENT '广告名称',
            `link` varchar(200) DEFAULT NULL COMMENT '跳转链接',
            `advertisePicUrl` varchar(500) DEFAULT NULL COMMENT '广告图片',
            `createTime` datetime DEFAULT NULL COMMENT '创建时间',
            `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
            `status` int(2) DEFAULT '1' COMMENT '是否显示（0不显示 1显示）',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行业分类广告';*/

    private Long id;
    private Long industryId;
    private String advertiseName;
    private String link;
    private String advertisePicUrl;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public String getAdvertiseName() {
        return advertiseName;
    }

    public void setAdvertiseName(String advertiseName) {
        this.advertiseName = advertiseName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAdvertisePicUrl() {
        return advertisePicUrl;
    }

    public void setAdvertisePicUrl(String advertisePicUrl) {
        this.advertisePicUrl = advertisePicUrl;
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
