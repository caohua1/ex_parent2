package com.ex.dao;

import com.ex.entity.Orders;
import com.ex.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersDao {

    public List<OrderVo> selectUserByMerchantId(Long merchantId);

    //查询购买此商家的用户的数量，以及产生的订单总数
    public Map selectUserByMerchantIdCount(Long merchantId);

    Orders selectAll(@Param("id") long id);

    /**
     * 第二种方式
     */
    //先查询所有的用户，分页查询
    public List<OrderVo> selectUserByMerchantId2(Long merchantId);

    //查询用户的累计消费
    public Double selectUserMoneyByMerchantId2(Map map);

    //某用户的待发货量总数
    public Integer selectUserOrdersCountByMerchantId2(Map map);

    //查询用户的总数
    public Integer selectUserCountByMerchantId2(Long merchantId);

    //查询此用户在此商家的待发货的详情，分页查询
    public List<OrderVo> selectUserOrdersByMerchantId2(Map map);

    int updateOrdersStatusById(@Param("updateTime") Date updateTime,@Param("status") int status,@Param("id") Long id);
}
