package com.ex.dao;

import com.ex.entity.UserAppRegist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    List<UserAppRegist> findByPage(Map map);

    Integer findUserCount(Map map);

    //后台修改用户密码。注销账号
    public Integer updateUserInfo(UserAppRegist userAppRegist);
}
