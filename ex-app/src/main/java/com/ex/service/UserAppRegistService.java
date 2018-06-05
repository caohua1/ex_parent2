package com.ex.service;

import com.ex.entity.UserAppRegist;
import com.github.pagehelper.PageInfo;
import com.ex.util.PageRequest;
import org.apache.ibatis.annotations.Param;


/**
 * @ClassName UserAppRegistService
 * @Description 用户注册接口
 * @Author sanmu
 * @Date 2018/6/1 10:10
 * @Version 1.0
 **/
public interface UserAppRegistService {
    UserAppRegist insertUserAppRegist(UserAppRegist userAppRegist);

    UserAppRegist checkUserName(String username);

    UserAppRegist selectUserAppRegistById(long id);

    PageInfo<UserAppRegist> findByPage(PageRequest page);

    boolean checkPassword(String passwordOne,String passwordTwo,String username);

    String checkSMS(String username);

}
