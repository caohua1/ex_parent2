package com.ex.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.ShareOrderDao;
import com.ex.entity.ProductInfoManage;
import com.ex.entity.ShareOrder;
import com.ex.entity.ShareOrderInfo;
import com.ex.service.ShareOrderService;
import com.ex.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0")
public class ShareOrderServiceImpl implements ShareOrderService {

    /**
     * 分享订单Dao
     */
    @Autowired
    private ShareOrderDao shareOrderDao;

    /**
     * 按条件查询所有分享信息
     *
     * @param shareOrder
     * @param pageRequest
     * @return
     */
    @Override
    public List<ShareOrder> selectShareOrderAll(ShareOrder shareOrder, PageRequest pageRequest) {
        List<ShareOrder> shareOrders = shareOrderDao.selectShareOrderAll(shareOrder);
        return shareOrders;
    }

    /**
     * 按分享人id查询所有分享信息
     * @param shareUserId
     * @return
     */
    @Override
    public List<ShareOrder> selectShareOrderByShareUserIdAll(long shareUserId) {
        List<ShareOrder> shareOrders = shareOrderDao.selectShareOrderByShareUserIdAll(shareUserId);
        return shareOrders;
    }

    /**
     * 按条件id精确查找分享信息
     *
     * @param id
     * @return
     */
    @Override
    public ShareOrder selectShareOrderById(Long id) {
        return shareOrderDao.selectShareOrderById(id);
    }

    /**
     * 添加分享信息
     *
     * @param shareOrder
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int insertShareOrder(ShareOrder shareOrder) {
        shareOrder.setCreateTime(new Date());
        return shareOrderDao.insertShareOrder(shareOrder);
    }

    /**
     * 修改分享信息
     *
     * @param shareOrder
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int uodateShareOrder(ShareOrder shareOrder) {
        shareOrder.setUpdateTime(new Date());
        return shareOrderDao.uodateShareOrder(shareOrder);
    }

    @Override
    public ShareOrderInfo selectShareOrderInfo(Map<String, Object> map) {
        long merchantId = 1L;
        if (map.get("merchantId") != null)
            merchantId = (long) map.get("merchantId");
        int payStatus = 1;
        if (map.get("payStatus") != null)
            payStatus = (int) map.get("payStatus");
        return shareOrderDao.selectShareOrderInfo(merchantId, payStatus);
    }

    @Override
    public ProductInfoManage selectproductinfoById(Long productinfoid) {
        return shareOrderDao.selectproductinfoById(productinfoid);
    }
}
