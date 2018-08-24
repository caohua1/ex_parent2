package com.ex.dao;

import com.ex.entity.UserAppRegist;
import com.ex.entity.UserTransaction;
import com.ex.vo.UserMoneyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    List<UserAppRegist> findByPage(Map map);

    Integer findUserCount(Map map);

    //后台修改用户密码。注销账号
    public Integer updateUserInfo(UserAppRegist userAppRegist);

    //======================后台查询用户的资金账户明细
    //可用余额，用户id
    public List<UserMoneyVo> selectUserYuE(Map map);
    //提取中的金额
    public Double selectTQMoney(Long registUserId);
    //交易明细
    public List<UserTransaction> selectUserTransaction(Map map);
}
