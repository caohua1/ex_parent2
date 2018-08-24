package com.ex.service.impl;

import com.ex.dao.UserAppInfoDao;
import com.ex.dao.UserDao;
import com.ex.entity.UserAppRegist;
import com.ex.entity.UserTransaction;
import com.ex.service.UserService;
import com.ex.util.PageRequest;
import com.ex.vo.UserMoneyVo;
import com.ex.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserAppInfoDao userAppInfoDao;

    /**
     * 查询所有的注册用户的注册信息
     * @param page
     * @return
     */
    @Override
    public PageInfo<UserAppRegist> findAll(Map map, PageRequest page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<UserAppRegist> users = userDao.findByPage(map);
        PageInfo<UserAppRegist> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    /**
     * 根据用户id查询用户的详情
     * @param id
     * @return
     */
    @Override
    public UserVo findByUserId(Long id) {
        return userAppInfoDao.findByUserId(id);
    }

    /**
     * 查询总数
     * @return
     */
    @Override
    public Integer findUserCount(Map map) {
        return userDao.findUserCount(map);
    }

    /**
     * 后台修改用户密码，注销账号
     * @param userAppRegist
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public Integer updateUserInfo(UserAppRegist userAppRegist) {
        return userDao.updateUserInfo(userAppRegist);
    }

    /**
     * 可用余额，用户id(分页，条件查询)
     * @param map
     * @return
     */
    @Override
    public PageInfo<UserMoneyVo> selectUserMoneyByParam(Map map,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<UserMoneyVo> userMoneyVos = userDao.selectUserYuE(map);
        if(userMoneyVos!=null && userMoneyVos.size()>0){
            for(int i=0;i<userMoneyVos.size();i++){
                Double tqMoney = userDao.selectTQMoney(userMoneyVos.get(i).getRegistUserId());
                if(tqMoney!=null){
                    userMoneyVos.get(i).setTQMoney(tqMoney);
                }else{
                    userMoneyVos.get(i).setTQMoney(0.0);
                }
                if(userMoneyVos.get(i).getYuE()==null){
                    userMoneyVos.get(i).setYuE(0.0);
                }

            }
        }
        PageInfo<UserMoneyVo> pageInfo = new PageInfo<>(userMoneyVos);
        pageInfo.setSize(userMoneyVos.size());
        return pageInfo;
    }


    /**
     * 用户，交易明细（分页，条件查询）
     * @param map
     * @return
     */
    @Override
    public PageInfo<UserTransaction> selectUserTransaction(Map map,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<UserTransaction> userTransactions = userDao.selectUserTransaction(map);
        PageInfo<UserTransaction> pageInfo = new PageInfo<>(userTransactions);
        pageInfo.setSize(userTransactions.size());
        return pageInfo;
    }
}
