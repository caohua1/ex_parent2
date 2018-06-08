package com.ex.service;

import com.ex.entity.UserAppRegist;
import com.github.pagehelper.PageInfo;
import com.ex.util.PageRequest;


/**
 * @ClassName UserAppRegistService
 * @Description 用户注册接口
 * @Author sanmu
 * @Date 2018/6/1 10:10
 * @Version 1.0
 **/
public interface UserAppRegistService {
    //用户注册
    boolean insertUserAppRegist(UserAppRegist userAppRegist);
    //用户登陆或校验用户名是否存在
    UserAppRegist userLoginOrCheckUserName(String username);
    //查询所有注册用户信息
    PageInfo<UserAppRegist> findByPage(PageRequest page);
}
