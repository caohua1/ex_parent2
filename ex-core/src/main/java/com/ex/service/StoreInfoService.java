package com.ex.service;

import com.ex.entity.StoreInfo;
import com.ex.util.PageRequest;
import com.ex.vo.StoreInfoVo;
import com.github.pagehelper.PageInfo;


public interface StoreInfoService {

    /**
     * 添加店铺信息
     * @param storeInfo
     * @return
     */
    int insertStoreInfo(StoreInfo storeInfo);

    PageInfo<StoreInfoVo> byConditionsQuery(PageRequest page, StoreInfo storeInfo);

    int updateStoreInfo(StoreInfo storeInfo);

}
