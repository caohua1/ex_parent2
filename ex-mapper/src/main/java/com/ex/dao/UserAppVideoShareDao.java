package com.ex.dao;

import com.ex.vo.UserAppVideoShare;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserAppVideoShareDao {

    public List<UserAppVideoShare> selectUserAppVideoShare(Map contMap);

    public int updateUserAppVideoShare(Map contMap);

}
