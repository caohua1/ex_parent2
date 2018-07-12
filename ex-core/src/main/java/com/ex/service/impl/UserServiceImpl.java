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

import java.util.List;

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
    public PageInfo<UserAppRegist> findAll(PageRequest page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<UserAppRegist> users = userDao.findByPage();
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
    public Integer findUserCount() {
        return userDao.findUserCount();
    }
}
