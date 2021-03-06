package com.ex.service;

import com.ex.entity.ProductClassify;
import com.ex.entity.StoreInfo;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.ex.vo.StoreInfoVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;


public interface AppProductClassifyService {
    public PageInfo<ProductClassify> selectProductClassify(ProductClassify productClassify, PageRequest pageRequest);
    public Integer selectProductClassifyCount(ProductClassify productClassify);
    //根据二级分类查询商家列表（商家店铺）
    public PageInfo<StoreInfoVo> byConditionsQuery(PageRequest page, StoreInfoVo storeInfoVo);

    //根据merchantId查询某商家的所有的商品
    public PageInfo<ProductInfoManageVo> selectProductsByMerchantId(Map map,PageRequest pageRequest);
    public List<ProductInfoManageVo> selectProductsByMerchantId2(Map map);

    //查询商品详情
    public ProductInfoManageVo selectProductInfoById(Long id);
    //根据店铺id查询此店铺的商品类别，（三级分类）
    public PageInfo<ProductClassify> selectProductClassifyByStoreId(Long storeId,PageRequest pageRequest);

}
