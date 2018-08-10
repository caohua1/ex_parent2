package com.ex.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.ShareOrderDao;
import com.ex.entity.ProductPropertySet;
import com.ex.entity.ShareOrder;
import com.ex.vo.ShareOrderInfoPCVo;
import com.ex.service.ShareOrderService;
import com.ex.util.PageRequest;
import com.ex.vo.OrderVo;
import com.ex.vo.ProductInfoManageVo;
import com.ex.vo.ShareOrderInfoVo;
import com.ex.vo.ShareOrderVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(version = "1.1.0")
public class ShareOrderServiceImpl implements ShareOrderService {

    /**
     * 分享订单Dao
     */
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private ShareOrderDao shareOrderDao;
    @Autowired
    private ProductPropertySetDao productPropertySetDao;
    @Autowired
    private ProductInfoManageDao productInfoManageDao;

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
    public List<ShareOrderVo> selectShareOrderByShareUserIdAll(Long shareUserId,Long productInfoId) {
        List<ShareOrderVo> shareOrders = shareOrderDao.selectShareOrderByShareUserIdAll(shareUserId,productInfoId);
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

    /**
     * 查询顶部统计数据
     * @param map
     * @return
     */
    @Override
    public ShareOrderInfoPCVo selectShareOrderInfo(Map<String, Object> map) {
        long merchantId = 1L;
        if (map.get("merchantId") != null)
            merchantId = (long) map.get("merchantId");
        int payStatus = 1;
        if (map.get("payStatus") != null)
            payStatus = (int) map.get("payStatus");
        return shareOrderDao.selectShareOrderInfo(merchantId, payStatus);
    }

    /**
     * 用户APP我的分享顶部数据
     * @param userId
     * @return
     */
    @Override
    public ShareOrderInfoVo selectShareOrederInfoVo(Long userId) {
        return shareOrderDao.selectShareOrederInfoVo(userId,new Date());
    }

    /**
     * 后台，订单管理，分享订单
     * @param shareOrderInfoVo
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<ShareOrderInfoVo> selectAllShareOrderByParam(ShareOrderInfoVo shareOrderInfoVo, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<ShareOrderInfoVo> shareOrderInfoVos = shareOrderDao.selectAllShareOrderByParam(shareOrderInfoVo);
        PageInfo<ShareOrderInfoVo> pageInfo = new PageInfo<>(shareOrderInfoVos);
        pageInfo.setSize(shareOrderInfoVos.size());
        return pageInfo;
    }


}
