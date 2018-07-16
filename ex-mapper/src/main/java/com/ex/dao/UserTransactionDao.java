package com.ex.dao;

import com.ex.entity.UserTransaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTransactionDao {

    //按ID查询所有的支出和收入信息
    List<UserTransaction> selectUserTransactionAll(Long registUserId);

}
