package com.ex.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.MyCollectDao;
import com.ex.entity.MyCollect;
import com.ex.service.MyCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyCollectServiceImpl implements MyCollectService {

    @Autowired
    private MyCollectDao myCollectDao;

    /**
     * 收藏商品
     * @param myCollect
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer insertMyCollect(MyCollect myCollect) {
        return myCollectDao.insertMyCollect(myCollect);
    }
}
