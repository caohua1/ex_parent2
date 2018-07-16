package com.ex.service;

import com.ex.entity.UserTransaction;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

public interface UserTransactionService {
    //按ID查询所有的支出和收入信息
    PageInfo<UserTransaction> selectUserTransactionAll(Long registUserId, PageRequest page);
}
