package com.ex.service.impl;

import com.ex.dao.UserAppPersonDataDao;
import com.ex.entity.UserAppPersonData;
import com.ex.service.UserAppPersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserAppPersonDataServiceImpl implements UserAppPersonDataService {

    @Autowired
    private UserAppPersonDataDao userAppPersonDataDao;

    @Override
    public int updateUserAppPersonData(UserAppPersonData userAppPersonData) {
        userAppPersonData.setUpdatetime(new Date());
        return userAppPersonDataDao.updateUserAppPersonData(userAppPersonData);
    }
}
