package com.ex.vo;


import java.io.Serializable;

public class UserAppVo implements Serializable {

    private Long id;//用户Id
    private String Rphone;//注册手机号
    private String headUrl;//头像
    private String nickName;//昵称
    private String vxName;//微信昵称
    private String phone;//联系手机号
    private String realName;//真实姓名

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRphone() {
        return Rphone;
    }

    public void setRphone(String rphone) {
        Rphone = rphone;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getVxName() {
        return vxName;
    }

    public void setVxName(String vxName) {
        this.vxName = vxName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
