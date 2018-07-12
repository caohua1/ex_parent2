package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

/**
 * 视享管理实体类/和
 */

public class VideoShareManage {


    private Long uid;//商家上传视频文件信息id
    private Long rid;//商家（个人）唯一标识id
    private Long id;//视享竞价排名id
    private String username;//发布者
    private String fileUrl;//视频图片路径
    private String describe;//发布内容（说说）
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date uploadfileTime;//发布时间
    private String order;//排序
    private double money;//竞价排名（价格）
    private int playNum;//播放次数
    private int fileType;//类型（视频/图片）

    public VideoShareManage() {
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

    public VideoShareManage(Long uid,Long rid,Long id, String username, String fileUrl, String describe, Date uploadfileTime, String order, double money, int playNum, int fileType) {
        this.uid=uid;
        this.rid=rid;
        this.id = id;
        this.username = username;
        this.fileUrl = fileUrl;
        this.describe = describe;
        this.uploadfileTime = uploadfileTime;
        this.order = order;
        this.money = money;
        this.playNum = playNum;
        this.fileType = fileType;
    }

    public Long getRid() {
        return rid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getUploadfileTime() {
        return uploadfileTime;
    }

    public void setUploadfileTime(Date uploadfileTime) {
        this.uploadfileTime = uploadfileTime;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }
}
