package com.ex.service.impl;

import com.ex.dao.user.UserAppRegistDao;
import com.ex.entity.UserAppRegist;
import com.ex.service.UserAppRegistService;
import com.ex.util.CustomMD5;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Autowired
    private UserAppRegistDao userAppRegistDao;

    /**
     * @author sanmu
     * @Desription 注册用户
     * @date 2018/6/1 11:13
     * @Param [userAppRegist]
     * @return int
     **/
    @Override
    public UserAppRegist insertUserAppRegist(UserAppRegist userAppRegist) {
        try {
            userAppRegist.setPassword(CustomMD5.passwordAndSalt(userAppRegist.getPassword(),userAppRegist.getUsername()));
                return selectUserAppRegistById(userAppRegistDao.insertUserAppRegist(userAppRegist));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author sanmu
     * @Desription 登陆方法
     * @date 2018/6/1 15:02
     * @Param [username]
     * @return com.ex.entity.UserAppRegist
     **/
    @Override
    public UserAppRegist userAppLogin(String username) {
        return null;
    }

    /**
     * @author sanmu
     * @Desription 按id查询用户 返回用户对象
     * @date 2018/6/1 11:14
     * @Param [id]
     * @return com.ex.entity.UserAppRegist
     **/
    @Override
    public UserAppRegist selectUserAppRegistById(long id) {
        return userAppRegistDao.selectUserAppRegistById(id);
    }

    /**
     * @author sanmu
     * @Desription 查询所有用户信息
     * @date 2018/6/1 11:14
     * @Param [page]
     * @return com.github.pagehelper.PageInfo<com.ex.entity.UserAppRegist>
     **/
    @Override
    public PageInfo<UserAppRegist> findByPage(PageRequest page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<UserAppRegist> users = userAppRegistDao.findByPage();
        PageInfo<UserAppRegist> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

}
