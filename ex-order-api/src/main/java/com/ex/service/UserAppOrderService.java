package com.ex.service;

import com.ex.entity.UserOrder;

import java.util.List;
import java.util.Map;

public interface UserAppOrderService {
    //按用户Id查询该用户所有订单信息
    List<UserOrder> selectUserOrderByid(Map<String,Object> map);
    //查询所有订单信息
    List<UserOrder> selectUserOrderAll(UserOrder userOrder);
    //修改订单信息
    int updateUserOrder(UserOrder userOrder);
    //添加订单信息
    int insertUserOrder(UserOrder userOrder);
}
