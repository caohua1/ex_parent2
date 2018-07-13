package com.ex.service.impl;

import com.ex.dao.MerchantRegistDao;
import com.ex.entity.MerchantRegist;
import com.ex.service.MerchantRegistService;
import com.ex.util.CustomMD5;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName ex_parent
 * @ClassName MerchantRegistServiceImpl
 * @Description TODO 商家注册和登陆
 * @Author sanmu
 * @Date 2018/6/6 10:26
 * @Version 1.0
 **/
@Service
public class MerchantRegistServiceImpl implements MerchantRegistService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MerchantRegistDao merchantRegistDao;

    /**
     * @Description TODO 商家注册
     * @param merchantRegist
     * @return true/false
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public boolean insertMerchantRegist(MerchantRegist merchantRegist) {
            merchantRegist.setPassword(CustomMD5.passwordAndSalt(merchantRegist.getPassword(),merchantRegist.getUsername()));
            merchantRegistDao.insertMerchantRegist(merchantRegist);
            return true;
    }

    /**
     * @Description TODO 商家登陆
     * @param username
     * @return
     */
    @Override
    public MerchantRegist merchantLoginOrCheckUserName(String username) {
        logger.info("Request comming to Login user");
        MerchantRegist userAppRegist = merchantRegistDao.merchantLoginOrCheckUserName(username);
        if (userAppRegist==null)
            return null;
        return userAppRegist;
    }

    /**
     * @Description TODO 获取商家列表
     * @param page
     * @return
     */
    @Override
    public PageInfo<MerchantRegist> findByPage(PageRequest page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<MerchantRegist> users = merchantRegistDao.findByPage();
        PageInfo<MerchantRegist> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    /**
     * 根据用户名查询互推商家id
     * @param username
     * @return
     */
    @Override
    public Long selectMutualReferrringById(String username) {
        return merchantRegistDao.selectMutualReferrringById(username);
    }
}
