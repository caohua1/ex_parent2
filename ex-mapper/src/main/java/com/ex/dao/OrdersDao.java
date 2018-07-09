package com.ex.dao;

import com.ex.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersDao {

    public List<OrderVo> selectUserByMerchantId(Long merchantId);

    //查询购买此商家的用户的数量，以及产生的订单总数
    public Map selectUserByMerchantIdCount(Long merchantId);
}
