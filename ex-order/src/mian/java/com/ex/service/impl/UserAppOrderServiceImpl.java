package com.ex.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.OrdersDao;
import com.ex.dao.UserOrderDao;
import com.ex.entity.UserOrder;
import com.ex.service.UserAppOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service(version = "1.0.0")
public class UserAppOrderServiceImpl implements UserAppOrderService {

    @Autowired
    private UserOrderDao userOrderDao;
    @Autowired
    private OrdersDao ordersDao;

    private SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 按用户Id查询该用户所有订单信息
     *
     * @param registUserId
     * @return
     */
    @Override
    public List<UserOrder> selectUserOrderByid(Long registUserId) {
        return userOrderDao.selectUserOrderByid(registUserId, null);
    }

    /**
     * 按用户Id查询该用户所有订单信息
     *
     * @param registUserId
     * @return
     */
    @Override
    public List<UserOrder> selectUserOrderByIdAndStatus(Long registUserId) {
        return userOrderDao.selectUserOrderByid(registUserId, 4);
    }

    /**
     * 查询所有订单信息
     *
     * @return
     */
    @Override
    public List<UserOrder> selectUserOrderAll() {
        return userOrderDao.selectUserOrderAll();
    }

    /**
     * //修改用户和订单表关联信息状态
     *
     * @param status
     * @param userOrderId
     * @param orderId 订单Id
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int updateUserOrder(Integer status, Long userOrderId,Long orderId,String wuLiuNum) throws ParseException {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("updateTime", new Date());
        map.put("status", status);
        map.put("id", orderId);
        if(wuLiuNum!=null && !("").equals(wuLiuNum)){//发货后，商家填写物流编号
            map.put("WuLiuNum",wuLiuNum);
        }
        if (status == 4) {
            //生成十天后后的时间
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MINUTE, 14400);
            String currentTime = sf.format(c.getTime());
            map.put("finishTime",sf.parse(currentTime));
        }
        ordersDao.updateOrdersStatusById(map);//修改订单表状态
        return userOrderDao.updateUserOrder(new Date(), status, userOrderId);//修改用户和订单关系表状态
    }

    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int insertUserOrder(UserOrder userOrder) {
        userOrder.setCreateTime(new Date());
        return userOrderDao.insertUserOrder(userOrder);
    }
}
