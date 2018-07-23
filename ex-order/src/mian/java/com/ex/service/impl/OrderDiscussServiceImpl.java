package com.ex.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.OrderDiscussDao;
import com.ex.entity.OrderDiscuss;
import com.ex.service.OrderDiscussService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Service(version = "1.0.0")
public class OrderDiscussServiceImpl implements OrderDiscussService {

    @Autowired
    private OrderDiscussDao orderDiscussDao;

    /**
     * 用户对订单进行评论
     * @param orderDiscuss
     * @return
     */
    @Override
    public int insertOrderDiscuss(OrderDiscuss orderDiscuss) {
        orderDiscuss.setDiscussTime(new Date());
        return orderDiscussDao.insertOrderDiscuss(orderDiscuss);
    }
}
