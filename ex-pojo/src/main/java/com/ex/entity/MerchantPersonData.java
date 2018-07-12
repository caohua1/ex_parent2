package com.ex.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MerchantPersonData {
    private Long id;
    private Long merchantld;
    private String herdUrl;
    private String nickName;
    private int sex;
    private String address;
    private String job;
    private int marrige;
    private String email;
    private Date createTime;
    private Date updateTime;
    private int status;

    @Override
    public String toString() {
        return "MerchantPersonData{" +
                "id=" + id +
                ", merchantld=" + merchantld +
                ", herdUrl='" + herdUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", marrige=" + marrige +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }

    public MerchantPersonData() {
    }

    public MerchantPersonData(Long id, Long merchantld, String herdUrl, String nickName, int sex, String address, String job, int marrige, String email, Date createTime, Date updateTime, int status) {
        this.id = id;
        this.merchantld = merchantld;
        this.herdUrl = herdUrl;
        this.nickName = nickName;
        this.sex = sex;
        this.address = address;
        this.job = job;
        this.marrige = marrige;
        this.email = email;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantld() {
        return merchantld;
    }

    public void setMerchantld(Long merchantld) {
        this.merchantld = merchantld;
    }

    public String getHerdUrl() {
        return herdUrl;
    }

    public void setHerdUrl(String herdUrl) {
        this.herdUrl = herdUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMarrige() {
        return marrige;
    }

    public void setMarrige(int marrige) {
        this.marrige = marrige;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
