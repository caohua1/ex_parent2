package com.ex.service;

import com.ex.entity.OrderDiscuss;

public interface OrderDiscussService{
    //用户对订单进行评论
    int insertOrderDiscuss(OrderDiscuss orderDiscuss);
}
