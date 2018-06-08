package com.ex.service;

import com.ex.entity.MerchantorpersonUploadProduct;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface MerchantorpersonUploadProductService {


    public PageInfo<MerchantorpersonUploadProduct> selectMerchantorpersonUploadProduct(PageRequest page, Map conditionMap);

    public int updateStatus(Map statusMap);
}
