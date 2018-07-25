package com.ex.vo;

import com.ex.entity.Friend;

public class FriendVo extends Friend {

    private String headUrl;//头像路径
    private String nickName;//用户昵称
    private String username;//用户账号
    private Integer invitStatus;//邀请人状态
    private Integer BeInvitStatus;//被邀请人状态

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
