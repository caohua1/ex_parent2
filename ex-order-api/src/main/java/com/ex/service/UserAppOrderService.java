package com.ex.service;

import com.ex.entity.Orders;
import com.ex.entity.UserOrder;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface UserAppOrderService {
    //按用户Id查询该用户所有订单信息
    List<UserOrder> selectUserOrderByid(Long registUserId);
    List<UserOrder> selectUserOrderByIdAndStatus(Long registUserId);
    //查询所有订单信息
    List<UserOrder> selectUserOrderAll();
    //修改订单信息
    int updateUserOrder(Integer status, Long userOrderId,Long orderId,String wuLiuNum) throws ParseException;
    //添加订单信息
    int insertUserOrder(UserOrder userOrder);

}
