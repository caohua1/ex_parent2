package com.ex.service;

import com.ex.entity.UserAppRegist;
import com.ex.util.PageRequest;
import com.ex.vo.UserVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface UserService {
    PageInfo<UserAppRegist> findAll(Map map,PageRequest page);
    //查询用户的详情
    public UserVo findByUserId(Long id);
    Integer findUserCount(Map map);

    //后台修改用户密码。注销账号
    public Integer updateUserInfo(UserAppRegist userAppRegist);
}
