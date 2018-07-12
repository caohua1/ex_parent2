package com.ex.service;

import com.ex.entity.StoreInfo;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

public interface AppStoreInfoService {


    PageInfo<StoreInfo> byConditionsQuery(PageRequest page, StoreInfo storeInfo);
}
