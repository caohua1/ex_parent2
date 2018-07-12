package com.ex.service.impl;

import com.ex.dao.ShippingAddressDao;
import com.ex.entity.ShippingAddress;
import com.ex.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Autowired
    private ShippingAddressDao shippingAddressDao;

    /**
     * 用户添加新的收货地址
     * @param shippingAddress
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer insertShippingAddress(ShippingAddress shippingAddress) {
        return shippingAddressDao.insertShippingAddress(shippingAddress);
    }

    /**
     * 查询用户所有的收货地址
     * @param registUserId
     * @return
     */
    @Override
    public List<ShippingAddress> selectShippingAddress(Long registUserId) {
        return shippingAddressDao.selectShippingAddress(registUserId);
    }
}
