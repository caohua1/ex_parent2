package com.ex.vo;

import com.ex.entity.AppointmentMeet;

public class AppointmentMeetVo extends AppointmentMeet {

    private String username;//商家账户

    private String companyName;//公司名称

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
