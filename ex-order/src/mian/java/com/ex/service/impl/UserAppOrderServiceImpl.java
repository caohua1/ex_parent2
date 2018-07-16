package com.ex.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.OrdersDao;
import com.ex.dao.UserOrderDao;
import com.ex.entity.UserOrder;
import com.ex.service.UserAppOrderService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service(version = "1.0.0")
public class UserAppOrderServiceImpl implements UserAppOrderService {

    @Autowired
    private UserOrderDao userOrderDao;
    @Autowired
    private OrdersDao ordersDao;

    /**
     * 按用户Id查询该用户所有订单信息
     * @param registUserId
     * @return
     */
    @Override
    public List<UserOrder> selectUserOrderByid(Long registUserId) {
        return userOrderDao.selectUserOrderByid(registUserId,null);
    }

    /**
     * 按用户Id查询该用户所有订单信息
     * @param registUserId
     * @return
     */
    @Override
    public List<UserOrder> selectUserOrderByIdAndStatus(Long registUserId) {
        return userOrderDao.selectUserOrderByid(registUserId,4);
    }

    @Override
    public List<UserOrder> selectUserOrderAll() {
        return userOrderDao.selectUserOrderAll();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * //修改用户和订单表关联信息状态
     * @param status
     * @param userOrderId
     * @param orderId
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int updateUserOrder(int status, Long userOrderId,Long orderId) {
        updateTime = new Date();
        Map map = new HashMap();
        map.put("updateTime",updateTime);
        map.put("status",status);
        map.put("orderId",orderId);
        ordersDao.updateOrdersStatusById(map);//修改订单表状态
        return userOrderDao.updateUserOrder(updateTime,status,orderId);//修改用户和订单关系表状态
    }

    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int insertUserOrder(UserOrder userOrder) {
        userOrder.setCreateTime(new Date());
        return userOrderDao.insertUserOrder(userOrder);
    }
}
