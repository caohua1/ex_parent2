package com.ex.vo;

import com.ex.entity.MyUploadFile;

/**
 * 我享
 */
public class MyUploadFileVo extends MyUploadFile {

    private String username;//用户名（手机号注册）
    private String headUrl;//头像保存路径
    private String nickName;//用户昵称

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
