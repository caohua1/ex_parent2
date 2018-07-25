package com.ex.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.*;
import com.ex.entity.Orders;
import com.ex.entity.ShareOrder;
import com.ex.entity.StoreInfo;
import com.ex.entity.UserOrder;
import com.ex.service.ShareOrderService;
import com.ex.service.UserOrdersService;
import com.ex.util.PageRequest;
import com.ex.util.UUIDUtil;
import com.ex.vo.OrderVo;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.1")
public class UserOrdersServiceImpl implements UserOrdersService{


    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private UserOrderDao userOrderDao;
    @Autowired
    private OrderDiscussDao orderDiscussDao;
    @Autowired
    private ShareOrderService shareOrderService;
    @Autowired
    private StoreInfoDao storeInfoDao;
    @Autowired
    private ProductInfoManageDao productInfoManageDao;

    /**
     * 商家app首页的客户管理，根据merchantId查询购买过此商家商品的客户的信息（去重，一个用户在此商家有多个订单）(消费金额)，几笔待发货
     * @param merchantId
     * @return
     */
    @Override
    public PageInfo<OrderVo> selectUserByMerchantId(Long merchantId, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<OrderVo> orderVos = ordersDao.selectUserByMerchantId(merchantId);
        PageInfo<OrderVo> pageInfo = new PageInfo<>(orderVos);
        return pageInfo;
    }

    /**
     * 查询购买此商家的用户的数量，以及产生的订单总数
     * @param merchantId
     * @return
     */
    @Override
    public Map selectUserByMerchantIdCount(Long merchantId) {
        return ordersDao.selectUserByMerchantIdCount(merchantId);
    }




   //=========================================第二种方式

    /**
     * 先查询所有的用户，分页查询
     * @param merchantId
     * @return
     */
    @Override
    public PageInfo<OrderVo> selectUserByMerchantId2(Long merchantId,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<OrderVo> orderVos = ordersDao.selectUserByMerchantId2(merchantId);
        PageInfo<OrderVo> pageInfo = new PageInfo<>(orderVos);
        return pageInfo;
    }

    /**
     * 查询用户的累计消费
     * @param map
     * @return
     */
    @Override
    public Double selectUserMoneyByMerchantId2(Map map) {
        return ordersDao.selectUserMoneyByMerchantId2(map);
    }

    /**
     * 某用户的待发货量总数
     * @param map
     * @return
     */
    @Override
    public Integer selectUserOrdersCountByMerchantId2(Map map) {
        return ordersDao.selectUserOrdersCountByMerchantId2(map);
    }

    /**
     * 查询用户的总数
     * @param merchantId
     * @return
     */
    @Override
    public Integer selectUserCountByMerchantId2(Long merchantId) {
        return ordersDao.selectUserCountByMerchantId2(merchantId);
    }

    /**
     * 查询此用户在此商家的待发货的详情，分页查询
     * @param map
     * @return
     */
    @Override
    public PageInfo<OrderVo> selectUserOrdersByMerchantId2(Map map,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<OrderVo> orderVos = ordersDao.selectUserOrdersByMerchantId2(map);
        PageInfo<OrderVo> pageInfo = new PageInfo<>(orderVos);
        return pageInfo;
    }


    /**
     * 添加订单表，同时添加用户订单中间表，付款成功
     * @param orders
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public Boolean insertOrders(Orders orders, UserOrder userOrder, Long shareUserId, String shareUsername, String buyUsername, ProductInfoManageVo productInfoManageVo) {
        orders.setOrderNum(UUIDUtil.getOrderIdByUUId());
        Integer i = ordersDao.insertOrders(orders);
        //下单成功后，商品的库存量减少
        ProductInfoManageVo productInfoManageVo1 = new ProductInfoManageVo();
        productInfoManageVo1.setId(productInfoManageVo.getId());
        productInfoManageVo1.setStoreNum(0-orders.getProductNum());
        productInfoManageVo1.setUpdateTime(new Date());
        Integer n = productInfoManageDao.updateProductInfo(productInfoManageVo1);
        if(i>0 && n>0){
            userOrder.setCreateTime(new Date());
            userOrder.setOrderId(orders.getId());
            userOrder.setStatus(1);
            int j = userOrderDao.insertUserOrder(userOrder);
            //如果是分享订单，添加分享订单
            if(shareUserId!=null && shareUsername!=null){
                //5.如果是分享订单，添加分享订单表
                ShareOrder shareOrder = new ShareOrder();
                shareOrder.setBuyUserId(userOrder.getRegistUserId());//购买者id
                shareOrder.setBuyUsername(buyUsername); //购买者账号
                shareOrder.setShareUserId(shareUserId);//分享者id
                shareOrder.setShareUsername(shareUsername);//分享者账号
                shareOrder.setProductInfoId(orders.getProductInfoId()); //商品id
                shareOrder.setMerchantId(productInfoManageVo.getMerchantId()); //商家id
                shareOrder.setCreateTime(new Date());//下单时间
                StoreInfo storeInfo = new StoreInfo();
                storeInfo.setMerchantid(productInfoManageVo.getMerchantId());
                List<StoreInfo> storeInfos = storeInfoDao.byConditionsQuery(storeInfo);
                shareOrder.setMerchantName(storeInfos.get(0).getStorename());//商家名称
                shareOrder.setOrderMoney(orders.getOrderMoney());//订单金额
                shareOrder.setOrderNum(orders.getOrderNum());//订单编号
                int k = shareOrderService.insertShareOrder(shareOrder);
                return j>0 && i>0 && k>0 && n>0;
            }
            return j>0 && i>0 && n>0;
        }else{
            userOrder.setCreateTime(new Date());
            userOrder.setOrderId(orders.getId());
            userOrder.setStatus(0);
            int j = userOrderDao.insertUserOrder(userOrder);
            return j>0 && i>0 && n>0;
        }
    }

    /**
     * 修改订单的支付状态
     * @param map
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int updateOrdersStatusById(Map map) {
        return ordersDao.updateOrdersStatusById(map);
    }

    /**
     * //支付根据订单id查询订单金额
     * @param orderId
     * @return
     */
    @Override
    public Orders selectOrdersById(Long orderId) {
        return ordersDao.selectOrdersById(orderId);
    }


    /**
     * 商家的订单评论平均分数的计算（服务态度）
     * @param merchantId
     * @return
     */
    @Override
    public Double selectMerchantDiscussAvg(Long merchantId) {
        return orderDiscussDao.selectMerchantDiscussAvg(merchantId);
    }

    /**
     * 查询某商家的总的销售单数
     * @param merchantId
     * @return
     */
    @Override
    public Integer selectMerchantOrderNums(Long merchantId) {
        return ordersDao.selectMerchantOrderNums(merchantId);
    }


}
