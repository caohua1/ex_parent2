package com.ex;

import com.ex.dao.UserBrowseDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImpl implements Service {
    @Autowired
    private UserBrowseDao userBrowseDao;
    @Override
    public Integer deleteBrowse() {
        return userBrowseDao.deleteBrowse();
    }
}
