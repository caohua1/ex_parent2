package com.ex.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.OrdersDao;
import com.ex.service.UserOrdersService;
import com.ex.util.PageRequest;
import com.ex.vo.OrderVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Map;

@Service
public class UserOrdersServiceImpl implements UserOrdersService{


    @Autowired
    private OrdersDao ordersDao;

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
}
