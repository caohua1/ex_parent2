package com.ex.service;

import com.ex.entity.UserAppRegist;
import com.ex.util.PageRequest;
import com.ex.vo.UserVo;
import com.github.pagehelper.PageInfo;

public interface UserService {
    PageInfo<UserAppRegist> findAll(PageRequest page);
    //查询用户的详情
    public UserVo findByUserId(Long id);
    Integer findUserCount();
}
