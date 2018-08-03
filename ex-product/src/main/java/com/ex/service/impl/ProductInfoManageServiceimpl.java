package com.ex.service.impl;

import com.ex.dao.ProductInfoManageDao;
import com.ex.entity.ProductInfoManage;
import com.ex.service.ProductInfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ProductInfoManageServiceimpl implements ProductInfoManageService {

    @Autowired
    private ProductInfoManageDao productInfoManageDao;

    /**
     * 根据商户id查询商品
     * @param map
     * @return
     */
    @Override
    public List<ProductInfoManage> selectProductInfoManageByMerchantId(Map map) {
        return productInfoManageDao.selectProductInfoManageByMerchantId(map);
    }
}
