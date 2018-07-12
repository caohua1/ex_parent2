package com.ex.vo;

import com.ex.entity.AppointmentOrder;

public class AppointmentOrderVo extends AppointmentOrder {

    private String username;//商家账号

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
