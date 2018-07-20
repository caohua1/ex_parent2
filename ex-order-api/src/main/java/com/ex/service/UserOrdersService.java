package com.ex.service;
import com.ex.entity.Orders;
import com.ex.entity.UserOrder;
import com.ex.util.PageRequest;
import com.ex.vo.OrderVo;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageInfo;
import java.util.Map;


public interface UserOrdersService {

    //商家app首页的客户管理，根据merchantId查询购买过此商家商品的客户的信息（去重，一个用户在此商家有多个订单）(消费金额)，几笔待发货
    public PageInfo<OrderVo> selectUserByMerchantId(Long merchantId, PageRequest pageRequest);

    //查询购买此商家的用户的数量，以及产生的订单总数
    public Map selectUserByMerchantIdCount(Long merchantId);



    /**
     * 第二种方式
     */
    //先查询所有的用户，分页查询
    public PageInfo<OrderVo> selectUserByMerchantId2(Long merchantId,PageRequest pageRequest);

    //查询用户的累计消费
    public Double selectUserMoneyByMerchantId2(Map map);

    //某用户的待发货量总数
    public Integer selectUserOrdersCountByMerchantId2(Map map);

    //查询用户的总数
    public Integer selectUserCountByMerchantId2(Long merchantId);

    //查询此用户在此商家的待发货的详情，分页查询
    public PageInfo<OrderVo> selectUserOrdersByMerchantId2(Map map,PageRequest pageRequest);

    //添加订单
    public Boolean insertOrders(Orders orders, UserOrder userOrder,Long shareUserId,String shareUsername,String buyUsername, ProductInfoManageVo productInfoManageVo);

    //修改订单的支付状态（orders表）
    public int updateOrdersStatusById(Map map);


    //支付根据订单id查询订单金额
    public Orders selectOrdersById(Long orderId);

    //计算商家的平均评分，（所有订单的评论）
    public Double selectMerchantDiscussAvg(Long merchantId);

    //查询某商家的总销售单数
    public Integer selectMerchantOrderNums(Long merchantId);
}
