package com.ex.service.impl;

import com.ex.dao.UserDao;
import com.ex.service.UserService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public PageInfo<User> findAll(PageRequest page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<User> users = userDao.findByPage();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
}
