package com.ex.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.UserOrderDao;
import com.ex.entity.UserOrder;
import com.ex.service.UserAppOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service(version = "1.0.0")
public class UserAppOrderServiceImpl implements UserAppOrderService {

    @Autowired
    private UserOrderDao userOrderDao;

    @Override
    public List<UserOrder> selectUserOrderByid(Map<String,Object> map) {
        long registUserId = (long) map.get("registUserId");
        return userOrderDao.selectUserOrderByid(registUserId);
    }

    @Override
    public List<UserOrder> selectUserOrderAll(UserOrder userOrder) {
        return userOrderDao.selectUserOrderAll(userOrder);
    }

    @Override
    public int updateUserOrder(UserOrder userOrder) {
        return userOrderDao.updateUserOrder(userOrder);
    }

    @Override
    public int insertUserOrder(UserOrder userOrder) {
        return userOrderDao.insertUserOrder(userOrder);
    }
}
