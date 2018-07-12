package com.ex.vo;

import com.ex.entity.OrderDiscuss;

import java.io.Serializable;

public class OrderDiscussVo extends OrderDiscuss implements Serializable{

    private String headUrl;
    private String nickName;

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
