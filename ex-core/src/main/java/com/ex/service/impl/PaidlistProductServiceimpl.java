package com.ex.service.impl;

import com.ex.dao.PaidlistProductDao;
import com.ex.service.PaidlistProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class PaidlistProductServiceimpl implements PaidlistProductService {

    @Autowired
    protected PaidlistProductDao paidlistProductDao;

    /**
     * 商户竞价排名添加数据
     * @param conditionMap
     * @return
     */
    @Override
    public int insertPaidlistProduct(Map conditionMap) {
        return paidlistProductDao.insertPaidlistProduct(conditionMap);
    }

    /**
     * 根据订单号修改商户竞价排名数据支付状态
     * @param outTradeNo
     * @return
     */
    @Override
    public int updateState(String outTradeNo) {
        return paidlistProductDao.updateState(outTradeNo);
    }
}
