package com.ex.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.OrderDiscussDao;
import com.ex.entity.OrderDiscuss;
import com.ex.service.OrderDiscussService;
import com.ex.service.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service(version = "1.0.0")
public class OrderDiscussServiceImpl implements OrderDiscussService {

    @Autowired
    private OrderDiscussDao orderDiscussDao;


    @Autowired
    private UserOrdersService UserOrdersService;
    /**
     * 用户对订单进行评论
     * @param orderDiscuss
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public int insertOrderDiscuss(OrderDiscuss orderDiscuss) {
        orderDiscuss.setDiscussTime(new Date());
        int i = orderDiscussDao.insertOrderDiscuss(orderDiscuss);
        if (i>0) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", orderDiscuss.getOrderId());
            map.put("status", 14);
        }
        return i;
    }
}
