package com.ex.dao;

import com.ex.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserOrderDao {
    //按用户Id查询该用户所有订单信息
    List<UserOrder> selectUserOrderByid(@Param("registUserId") long registUserId);
    //查询所有订单信息
    List<UserOrder> selectUserOrderAll();
    //修改用户和订单表关联信息状态
    int updateUserOrder(@Param("updateTime") Date updateTime, @Param("status") int status, @Param("id") Long id);
    //添加用户和订单表关联信息
    int insertUserOrder(UserOrder userOrder);
}
