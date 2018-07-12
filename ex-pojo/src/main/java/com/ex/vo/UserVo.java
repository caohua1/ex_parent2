package com.ex.vo;

import com.ex.entity.UserAppInfo;

public class UserVo extends UserAppInfo{

 //个人资料
      private String headUrl;
      private String MyQRCode;
      private String nickName;
      private Integer sex;
      private Integer marriage;
      private String job;
      private String email;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
