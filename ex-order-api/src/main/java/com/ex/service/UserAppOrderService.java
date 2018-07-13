package com.ex.service;

import com.ex.entity.UserOrder;

import java.util.List;
import java.util.Map;

public interface UserAppOrderService {
    //按用户Id查询该用户所有订单信息
    List<UserOrder> selectUserOrderByid(long registUserId);
    List<UserOrder> selectUserOrderByIdAndStatus(long registUserId,int status);
    //查询所有订单信息
    List<UserOrder> selectUserOrderAll();
    //修改订单信息
    int updateUserOrder(int status, Long userOrderId,Long orderId);
    //添加订单信息
    int insertUserOrder(UserOrder userOrder);
}
