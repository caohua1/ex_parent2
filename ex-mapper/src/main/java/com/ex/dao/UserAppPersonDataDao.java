package com.ex.dao;

import com.ex.entity.UserAppPersonData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAppPersonDataDao {

    //修改会员信息
    int updateUserAppPersonData(UserAppPersonData userAppPersonData);

}
