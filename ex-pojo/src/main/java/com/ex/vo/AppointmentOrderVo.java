package com.ex.vo;

import com.ex.entity.AppointmentOrder;
import com.ex.entity.ProductInfoManage;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class AppointmentOrderVo extends AppointmentOrder {

    private String username;//商家账号
    private List<ProductInfoManage> productInfoManageList;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ProductInfoManage> getProductInfoManageList() {
        return productInfoManageList;
    }

    public void setProductInfoManageList(List<ProductInfoManage> productInfoManageList) {
        this.productInfoManageList = productInfoManageList;
    }


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
