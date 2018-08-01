package com.ex.service.impl;

import com.ex.dao.StoreInfoDao;
import com.ex.service.UserAppStoreInfoService;
import com.ex.vo.UserAppAgentStoreInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAppStoreInfoServiceImpl implements UserAppStoreInfoService {

    @Autowired
    private StoreInfoDao storeInfoDao;

    /**
     * 按商家ID查询用户APP可代理店铺的详细信息
     * @param merchantId 商家ID
     * @return
     */
    @Override
    public UserAppAgentStoreInfoVo selectUserAppAgentStoreInfo(Long merchantId) {
        return storeInfoDao.selectUserAppAgentStoreInfo(merchantId);
    }
}
