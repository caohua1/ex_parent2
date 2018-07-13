package com.ex.service.impl;

import com.ex.dao.StoreInfoDao;
import com.ex.entity.StoreInfo;
import com.ex.service.AppStoreInfoService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class AppStoreInfoServiceImpl implements AppStoreInfoService {
    @Autowired
    private StoreInfoDao storeInfoDao;

    /**
     * 分页查询商家，按条件查询（按照商品分类查询）
     * @param page
     * @param storeInfo
     * @return
     */
    @Override
    public PageInfo<StoreInfo> byConditionsQuery(PageRequest page, StoreInfo storeInfo) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<StoreInfo> storeInfos = storeInfoDao.byConditionsQuery(storeInfo);
        PageInfo<StoreInfo> pageInfo = new PageInfo<>(storeInfos);
        return pageInfo;
    }
}