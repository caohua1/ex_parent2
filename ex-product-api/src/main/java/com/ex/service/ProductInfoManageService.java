package com.ex.service;

import com.ex.entity.ProductInfoManage;

import java.util.List;
import java.util.Map;

public interface ProductInfoManageService {

    public List<ProductInfoManage> selectProductInfoManageByMerchantId(Map map);
}
