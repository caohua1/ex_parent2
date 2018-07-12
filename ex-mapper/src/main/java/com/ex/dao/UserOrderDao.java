package com.ex.dao;

import com.ex.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserOrderDao {
    //按用户Id查询该用户所有订单信息
    List<UserOrder> selectUserOrderByid(@Param("registUserId") long registUserId);
    //查询所有订单信息
    List<UserOrder> selectUserOrderAll(UserOrder userOrder);
    //修改订单信息
    int updateUserOrder(UserOrder userOrder);
    //添加订单信息
    int insertUserOrder(UserOrder userOrder);
}
