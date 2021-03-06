package com.ex.service.impl;



import com.ex.dao.UserAppRegistDao;
import com.ex.entity.UserAppRegist;
import com.ex.service.UserAppRegistService;
import com.ex.util.CustomMD5;
import com.ex.util.PageRequest;
import com.ex.vo.UserAppVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户注册和登陆接口
 */
@Service
public class UserAppRegistServiceImpl implements UserAppRegistService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserAppRegistDao userAppRegistDao;

    /**
     * 校验用户名是否存在
     * @param username
     * @return
     */
    @Override
    public UserAppRegist userLoginOrCheckUserName(String username) {
        logger.info("Request comming to Login user");
        UserAppRegist userAppRegist = userAppRegistDao.userLoginOrCheckUserName(username);
        if (userAppRegist==null)
            return null;
        return userAppRegist;
    }

    /**
     * 注册用户
     * @param userAppRegist
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
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

    @Override
    public int updateUserAppRegistPassword(String username, String password) {
        password = CustomMD5.passwordAndSalt(password,username);
        return userAppRegistDao.updateUserAppRegistPassword(username, password, new Date());
    }

    @Override
    public UserAppVo selectUserAppInfo(Long registUserId) {
        return userAppRegistDao.selectUserAppInfo(registUserId);
    }


}
