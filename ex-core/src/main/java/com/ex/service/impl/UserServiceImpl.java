package com.ex.service.impl;

import com.ex.dao.UserAppInfoDao;
import com.ex.dao.UserDao;
import com.ex.entity.UserAppRegist;
import com.ex.service.UserService;
import com.ex.util.PageRequest;
import com.ex.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserAppInfoDao userAppInfoDao;

    /**
     * 查询所有的注册用户的注册信息
     * @param page
     * @return
     */
    @Override
    public PageInfo<UserAppRegist> findAll(Map map, PageRequest page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<UserAppRegist> users = userDao.findByPage(map);
        PageInfo<UserAppRegist> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    /**
     * 根据用户id查询用户的详情
     * @param id
     * @return
     */
    @Override
    public UserVo findByUserId(Long id) {
        return userAppInfoDao.findByUserId(id);
    }

    /**
     * 查询总数
     * @return
     */
    @Override
    public Integer findUserCount(Map map) {
        return userDao.findUserCount(map);
    }

    /**
     * 后台修改用户密码，注销账号
     * @param userAppRegist
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public Integer updateUserInfo(UserAppRegist userAppRegist) {
        return userDao.updateUserInfo(userAppRegist);
    }
}
