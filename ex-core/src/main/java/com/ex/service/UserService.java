package com.ex.service;

import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;

public interface UserService {
    PageInfo<User> findAll(PageRequest page);
}
