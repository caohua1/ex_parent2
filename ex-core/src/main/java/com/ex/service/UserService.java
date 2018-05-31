package com.ex.service;

import com.ex.entity.UserAppRegist;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

public interface UserService {
    PageInfo<UserAppRegist> findAll(PageRequest page);
}
