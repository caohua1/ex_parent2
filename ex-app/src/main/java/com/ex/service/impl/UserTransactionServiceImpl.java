package com.ex.service.impl;

import com.ex.dao.UserTransactionDao;
import com.ex.entity.UserTransaction;
import com.ex.service.UserTransactionService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTransactionServiceImpl implements UserTransactionService {

    @Autowired
    private UserTransactionDao userTransactionDao;

    /**
     * 按ID查询所有的收入信息
     * @param registUserId
     * @return
     */
    @Override
    public List<UserTransaction> selectUserTransactionIncome(Long registUserId) {
        return userTransactionDao.selectUserTransactionIncome(registUserId);
    }

    /**
     * 按ID查询所有的支出信息
     * @param registUserId
     * @return
     */
    @Override
    public List<UserTransaction> selectUserTransactionDisburse(Long registUserId) {
        return userTransactionDao.selectUserTransactionDisburse(registUserId);
    }
}
