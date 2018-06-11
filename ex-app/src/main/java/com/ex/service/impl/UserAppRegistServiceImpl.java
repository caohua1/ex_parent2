package com.ex.service.impl;


import com.ex.dao.UserAppRegistDao;
import com.ex.entity.UserAppRegist;
import com.ex.service.UserAppRegistService;
import com.ex.util.CustomMD5;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName ex_parent
 * @ClassName UserAppRegistServiceImpl
 * @Description 用户注册和登陆接口
 * @Author sanmu
 * @Date 2018/6/1 10:11
 * @Version 1.0
 **/

@Service
public class UserAppRegistServiceImpl implements UserAppRegistService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserAppRegistDao userAppRegistDao;

    /**
     * @return com.ex.entity.UserAppRegist
     * @author sanmu
     * @Desription 校验用户名是否存在
     * @date 2018/6/1 15:02
     * @Param [username]
     **/
    @Override
    public UserAppRegist userLoginOrCheckUserName(String username) {
        logger.info("Request comming to Login user");
        UserAppRegist userAppRegist = userAppRegistDao.checkUserName(username);
        if (userAppRegist==null)
            return null;
        return userAppRegist;
    }

    /**
     * @return int
     * @author sanmu
     * @Desription 注册用户
     * @date 2018/6/1 11:13
     * @Param [userAppRegist]
     **/
    @Override
    public boolean insertUserAppRegist(UserAppRegist userAppRegist) {
        try {
            userAppRegist.setPassword(CustomMD5.passwordAndSalt(userAppRegist.getPassword(),userAppRegist.getUsername()));
            userAppRegistDao.insertUserAppRegist(userAppRegist);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * @return com.github.pagehelper.PageInfo<com.ex.entity.UserAppRegist>
     * @author sanmu
     * @Desription 查询所有用户信息
     * @date 2018/6/1 11:14
     * @Param [page]
     **/
    @Override
    public PageInfo<UserAppRegist> findByPage(PageRequest page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<UserAppRegist> users = userAppRegistDao.findByPage();
        PageInfo<UserAppRegist> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

}
