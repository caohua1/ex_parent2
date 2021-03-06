package com.ex.dao;

import com.ex.entity.AgentMerchant;
import com.ex.entity.Orders;
import com.ex.vo.OrderVo;
import com.ex.vo.PCOrderVo;
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

    //修改订单状态
    int updateOrdersStatusById(Map map);

    //添加订单
    public Integer insertOrders(Orders orders);

    //支付根据订单id查询订单金额
    public Orders selectOrdersById(Long orderId);

    //查询用户是否是此商家的代理
    public AgentMerchant selectMerchantAgent(Map map);

    //查询某商家的总销售单数
    public Integer selectMerchantOrderNums(Long merchantId);

    //某商家所有订单中支付完成，但未交易成功的金额（冻结金额）
    public Double selectMerchantDJMoney(Long merchantId);

    //查询某商家的客户量
    public Integer selectUserNum(Long merchantId);

    //商家七日内的订单量
    public Integer selectOrderNumsIn7(Long merchantId);


    //==================================后台，订单模块

    //分享订单（销售订单详情）
    public OrderVo selectShareOrderInfoById(Long id);
    //后台查询所有的订单
    public List<PCOrderVo> selectAllOrder(PCOrderVo pcOrderVo);
}
