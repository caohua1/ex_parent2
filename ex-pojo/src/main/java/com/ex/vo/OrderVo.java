package com.ex.vo;

import com.ex.entity.Orders;

import java.io.Serializable;
import java.util.List;


//一个用户可以在同一家店有多个订单
public class OrderVo extends Orders implements Serializable{

    private Long registUserId;
    private String nickName;//昵称
    private String headUrl;//头像
    private String consumption;//累计消费
    private Integer shipmentNum ;//待发货量
    private List<Orders> ordersList;//一个人有多个订单

    public Long getRegistUserId() {
        return registUserId;
    }

    public void setRegistUserId(Long registUserId) {
        this.registUserId = registUserId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public Integer getShipmentNum() {
        return shipmentNum;
    }

    public void setShipmentNum(Integer shipmentNum) {
        this.shipmentNum = shipmentNum;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
