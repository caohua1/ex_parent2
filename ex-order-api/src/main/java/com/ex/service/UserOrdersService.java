package com.ex.service;
import com.ex.entity.Orders;
import com.ex.util.PageRequest;
import com.ex.vo.OrderVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;


public interface UserOrdersService {

    //商家app首页的客户管理，根据merchantId查询购买过此商家商品的客户的信息（去重，一个用户在此商家有多个订单）(消费金额)，几笔待发货
    public PageInfo<OrderVo> selectUserByMerchantId(Long merchantId, PageRequest pageRequest);

    //查询购买此商家的用户的数量，以及产生的订单总数
    public Map selectUserByMerchantIdCount(Long merchantId);

    Orders selectAll(long id);

}
