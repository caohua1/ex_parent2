package com.ex.service.impl;

import com.ex.dao.ShareOrderDao;
import com.ex.entity.ProductInfoManage;
import com.ex.entity.ShareOrder;
import com.ex.entity.ShareOrderInfo;
import com.ex.service.ShareOrderService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ShareOrderServiceImpl implements ShareOrderService {

    @Autowired
    private ShareOrderDao shareOrderDao;

    /**
     * 按条件查询所有分享信息
     * @param shareOrder
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<ShareOrder> selectShareOrderAll(ShareOrder shareOrder,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<ShareOrder> shareOrders = shareOrderDao.selectShareOrderAll(shareOrder);
        PageInfo<ShareOrder> pageInfo = new PageInfo<>(shareOrders);
        return pageInfo;
    }

    /**
     * 按条件id精确查找分享信息
     * @param id
     * @return
     */
    @Override
    public ShareOrder selectShareOrderById(Long id) {
        return shareOrderDao.selectShareOrderById(id);
    }

    /**
     * 添加分享信息
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
    public ShareOrderInfo selectShareOrderInfo(long merchantId, int payStatus) {
        return shareOrderDao.selectShareOrderInfo(merchantId, payStatus);
    }

    @Override
    public ProductInfoManage selectproductinfoById(long productinfoid) {
        return shareOrderDao.selectproductinfoById(productinfoid);
    }
}
