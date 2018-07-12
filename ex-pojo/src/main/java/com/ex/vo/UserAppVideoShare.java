package com.ex.vo;

import com.ex.entity.MerchantorpersonUploadProduct;
import lombok.Data;

import java.util.Date;
@Data
public class UserAppVideoShare extends MerchantorpersonUploadProduct {

    private String headUrl;//头像路径
    private String nickName;//用户昵称

    public UserAppVideoShare(String headUrl, String nickName) {
        this.headUrl = headUrl;
        this.nickName = nickName;
    }
    public UserAppVideoShare(){

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
