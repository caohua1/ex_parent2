package com.ex.entity;

import java.util.Date;

/**
 * 用户个人资料
 */
public class UserAppPersonData {
    private Long id;//主键
    private Long registUserId;//用户id(与userapp_regist主键关联)
    private String headUrl;//头像保存路径
    private String MyQRCode;//我的二维码
    private String nickName;//昵称
    private Integer sex;//性别（0女 1男）
    private Integer marriage;//'婚否（0未婚 1已婚）
    private String job;//工作
    private String mail;//邮箱
    private Date createTime;//创建时间
    private Date updatetime;//修改时间
    private Integer status;//状态（0删除 1存在）

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

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getMyQRCode() {
        return MyQRCode;
    }

    public void setMyQRCode(String myQRCode) {
        MyQRCode = myQRCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
