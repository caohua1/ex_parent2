package com.ex.service;


import com.ex.entity.IndexAdvertising;
import com.ex.entity.ProductClassify;
import com.ex.entity.StoreInfo;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.ex.vo.StoreInfoVo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface ExIndexService {

    //用户app端，二享模块，查询所有的一级商品分类
    public PageInfo<ProductClassify> selectProductClassify(ProductClassify productClassify,PageRequest pageRequest);

    //通过一级商品分类查询所有的商家列表
    public PageInfo<StoreInfoVo> selectStoreInfosByProductClassifyId1(Long productClassifyId,PageRequest pageRequest);

    //查询推荐商品
    public PageInfo<ProductInfoManageVo> selectProductInfos(ProductInfoManageVo productInfoManageVo,PageRequest pageRequest);

    //查询推荐商家
    PageInfo<StoreInfoVo> byConditionsQuery(@Param("record") StoreInfoVo storeInfo,PageRequest pageRequest);

    //模糊查询，根据店铺名称
    public PageInfo<StoreInfoVo> selectStoreByStoreName(String storeName,PageRequest pageRequest);

    //广告图片，跳转路径
    public List<IndexAdvertising> selectAdvertising(Map map);

}
