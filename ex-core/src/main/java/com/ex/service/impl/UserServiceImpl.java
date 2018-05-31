package com.ex.service.impl;

import com.ex.dao.UserDao;
import com.ex.entity.UserAppRegist;
import com.ex.service.UserService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public PageInfo<UserAppRegist> findAll(PageRequest page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<UserAppRegist> users = userDao.findByPage();
        PageInfo<UserAppRegist> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
}
