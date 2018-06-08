package com.ex.service.impl;

import com.ex.dao.ViewManageDao;
import com.ex.entity.ViewManage;
import com.ex.service.ViewManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewManageServiceImpl implements ViewManageService {

    @Autowired
    private ViewManageDao viewManageDao;

    /**
     *给视图配置增加数据
     * @param viewManage
     * @return
     */
    @Override
    public int addViewManage(ViewManage viewManage) {
        return viewManageDao.addViewManage(viewManage);
    }
}
