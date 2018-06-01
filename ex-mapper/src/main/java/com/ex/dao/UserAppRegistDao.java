package com.ex.dao;

import com.ex.entity.UserAppRegist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName ex_parent
 * @ClassName UserAppRegistDao
 * @Description TODO
 * @Author sanmu
 * @Date 2018/5/31 18:10
 * @Version 1.0
 **/

@Mapper
public interface UserAppRegistDao {

    Long insertUserAppRegist(UserAppRegist userAppRegist);

    UserAppRegist userAppLogin(@Param("username") String username);

    UserAppRegist selectUserAppRegistById(@Param("id")long id);

    List<UserAppRegist> findByPage();
}
