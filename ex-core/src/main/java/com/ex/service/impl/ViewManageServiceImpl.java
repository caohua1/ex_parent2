package com.ex.service.impl;

import com.ex.dao.ViewManageDao;
import com.ex.entity.ViewManage;
import com.ex.service.ViewManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ViewManageServiceImpl implements ViewManageService {

    @Autowired
    private ViewManageDao viewManageDao;

    /**
     *给视图配置增加数据
     * @param viewManage
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public int addViewManage(ViewManage viewManage) {
        return viewManageDao.addViewManage(viewManage);
    }
}
