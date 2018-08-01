package com.ex.service;

import com.ex.entity.UserTransaction;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserTransactionService {
    //按ID查询所有的收入信息
    List<UserTransaction> selectUserTransactionIncome(Long registUserId);
    //按ID查询所有的支出信息
    List<UserTransaction> selectUserTransactionDisburse(Long registUserId);

}
