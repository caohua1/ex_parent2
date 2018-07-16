package com.ex.service;

import com.ex.entity.StoreInfo;
import com.ex.util.PageRequest;
import com.ex.vo.StoreInfoVo;
import com.github.pagehelper.PageInfo;

public interface AppStoreInfoService {


    PageInfo<StoreInfo> byConditionsQuery(PageRequest page, StoreInfo storeInfo);
    //通过二级商品分类，查询所有的商家列表
    public PageInfo<StoreInfoVo> selectStoreInfosByProductClassifyId2(Long productClassifyId, PageRequest pageRequest);
}
