package com.ex.service;
import com.ex.util.PageRequest;
import com.ex.vo.OrderVo;
import com.ex.vo.PCOrderVo;
import com.github.pagehelper.PageInfo;



public interface PCOrderService {
    //==================================后台，订单模块
    //后台查询所有的订单
    public PageInfo<PCOrderVo> selectAllOrder(PCOrderVo pcOrderVo, PageRequest pageRequest);

    //分享订单
    public OrderVo selectShareOrderInfoById(Long id);
}
