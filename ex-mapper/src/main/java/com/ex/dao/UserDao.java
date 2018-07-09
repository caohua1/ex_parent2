package com.ex.dao;

import com.ex.entity.UserAppRegist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<UserAppRegist> findByPage();

    Integer findUserCount();
}
