package com.ex.entity;

import lombok.Data;


/**
 *视享竞价排名管理实体类
 */
@Data
public class PaidLlistingManage extends PaidlistProduct{

    private String describe;
    private String username;
    private String fileUrl;


    public PaidLlistingManage() {
        super();
    }



    public PaidLlistingManage(String describe, String username, String fileUrl) {
        this.describe = describe;
        this.username = username;
        this.fileUrl = fileUrl;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
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
}
