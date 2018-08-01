package com.ex.dao;

import com.ex.entity.UserTransaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTransactionDao {

    //按ID查询所有的收入信息
    List<UserTransaction> selectUserTransactionIncome(Long registUserId);

    //按ID查询所有的支出信息
    List<UserTransaction> selectUserTransactionDisburse(Long registUserId);
}
