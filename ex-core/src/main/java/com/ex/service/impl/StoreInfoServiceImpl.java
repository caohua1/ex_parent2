package com.ex.service.impl;

import com.ex.dao.StoreInfoDao;
import com.ex.entity.StoreInfo;
import com.ex.service.StoreInfoService;
import com.ex.util.PageRequest;
import com.ex.vo.StoreInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreInfoServiceImpl implements StoreInfoService {

    @Autowired
    private StoreInfoDao storeInfoDao;

    /**
     * 添加店铺信息
     * @param storeInfo
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int insertStoreInfo(StoreInfo storeInfo) {
        return storeInfoDao.insertStoreInfo(storeInfo);
    }

    /**
     * 按条件查询店铺信息
     * @param page
     * @param storeInfoVo
     * @return
     */
    @Override
    public PageInfo<StoreInfoVo> byConditionsQuery(PageRequest page, StoreInfoVo storeInfoVo) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<StoreInfoVo> storeInfos = storeInfoDao.byConditionsQuery(storeInfoVo);
        PageInfo<StoreInfoVo> pageInfo = new PageInfo<>(storeInfos);
        return pageInfo;
    }

    /**
     * 修改店铺信息
     * @param storeInfo
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int updateStoreInfo(StoreInfo storeInfo) {
        storeInfoDao.updateStoreInfo(storeInfo);
        return 0;
    }
}
