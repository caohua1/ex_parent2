package com.ex.service.impl;


import com.ex.dao.UserAppVideoShareDao;
import com.ex.service.UserAppVideoShareService;
import com.ex.vo.UserAppVideoShare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class UserAppVideoShareServicelmpl implements UserAppVideoShareService {

    @Autowired
    private UserAppVideoShareDao userAppVideoShareDao;

    /**
     * 用户app视享
     * @param contMap
     * @return
     */
    @Override
    public List<UserAppVideoShare> selectUserAppVideoShare(Map contMap) {
        return userAppVideoShareDao.selectUserAppVideoShare(contMap);
    }

    /**
     * 修改点赞次数
     * @param contMap
     * @return
     */
    @Override
    public int updateUserAppVideoShare(Map contMap) {
        return userAppVideoShareDao.updateUserAppVideoShare(contMap);
    }
}
