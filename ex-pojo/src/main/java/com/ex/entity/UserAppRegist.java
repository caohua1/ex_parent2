package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName ex_parent
 * @ClassName userapp_regist
 * @Description TODO Appy用户注册表
 * @Author sanmu
 * @Date 2018/5/31 18:02
 * @Version 1.0
 **/

public class UserAppRegist implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String RId;
    private String Rphone;
    private Integer identity;
    private Integer status;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registtime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatetime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRId() {
        return RId;
    }

    public void setRId(String RId) {
        this.RId = RId;
    }

    public String getRphone() {
        return Rphone;
    }

    public void setRphone(String rphone) {
        Rphone = rphone;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
