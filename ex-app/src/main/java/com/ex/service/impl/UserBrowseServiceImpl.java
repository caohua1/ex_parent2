package com.ex.service.impl;

import com.ex.dao.UserBrowseDao;
import com.ex.entity.UserBrowse;
import com.ex.service.UserBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserBrowseServiceImpl implements UserBrowseService {


    @Autowired
    private UserBrowseDao userBrowseDao;

    /**
     * 用户浏览商家商品（店铺记录）
     * @param userBrowse
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer insertUserBrowse(UserBrowse userBrowse) {
        return userBrowseDao.insertUserBrowse(userBrowse);
    }
}
