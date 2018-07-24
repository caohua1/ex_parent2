package com.ex.dao;

import com.ex.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAppInfoDao {

    public UserVo findByUserId(Long registUserId);
    public Integer updateUserAppInfo(UserVo userVo);
}
