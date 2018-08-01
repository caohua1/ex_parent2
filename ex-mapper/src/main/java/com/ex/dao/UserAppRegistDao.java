package com.ex.dao;

import com.ex.entity.UserAppRegist;
import com.ex.vo.UserAppVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName ex_parent
 * @ClassName UserAppRegistDao
 * @Description TODO 用户注册表
 * @Author sanmu
 * @Date 2018/5/31 18:10
 * @Version 1.0
 **/

@Mapper
public interface UserAppRegistDao {

    List<UserAppRegist> findByPage();

    int insertUserAppRegist(UserAppRegist userAppRegist);

    UserAppRegist userLoginOrCheckUserName(@Param("username") String username);

    int updateUserAppRegistPassword(@Param("username")String username, @Param("password")String password, @Param("updateTime")Date updateTime);

    UserAppVo selectUserAppInfo(Long registUserId);

}
