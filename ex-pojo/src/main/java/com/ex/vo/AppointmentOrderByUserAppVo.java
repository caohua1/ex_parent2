package com.ex.vo;

import com.ex.entity.AppointmentOrder;

public class AppointmentOrderByUserAppVo extends AppointmentOrder {
    private String storeName;
    private String picUrl;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
