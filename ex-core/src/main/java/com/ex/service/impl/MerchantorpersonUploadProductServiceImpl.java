package com.ex.service.impl;

import com.ex.dao.MerchantorpersonUploadProductDao;
import com.ex.entity.MerchantorpersonUploadProduct;
import com.ex.service.MerchantorpersonUploadProductService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class MerchantorpersonUploadProductServiceImpl implements MerchantorpersonUploadProductService {

    @Autowired
    public MerchantorpersonUploadProductDao merchantorpersonUploadProductDao;


    /**
     * 视享审核（条件查询）
     * @param page
     * @param conditionMap
     * @return
     */
    @Override
    public PageInfo<MerchantorpersonUploadProduct> selectMerchantorpersonUploadProduct(PageRequest page, Map conditionMap) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<MerchantorpersonUploadProduct> merchantorpersonUploadProducts = merchantorpersonUploadProductDao.selectMerchantorpersonUploadProduct(conditionMap);
        PageInfo<MerchantorpersonUploadProduct> pageInfo = new PageInfo<>(merchantorpersonUploadProducts);
        return pageInfo;
    }

    /**
     * 视享详情页 （状态审核）
     * @param statusMap
     * @return
     */
    @Override
    public int updateStatus(Map statusMap) {
        return merchantorpersonUploadProductDao.updateStatus(statusMap);
    }
}
