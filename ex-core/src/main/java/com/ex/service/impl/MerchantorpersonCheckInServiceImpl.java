package com.ex.service.impl;

import com.ex.dao.MerchantorpersonCheckInDao;
import com.ex.entity.MerchantorpersonCheckIn;
import com.ex.service.MerchantorpersonCheckInService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName ex_parent
 * @ClassName MerchantorpersonCheckInServiceImpl
 * @Description TODO
 * @Author sanmu
 * @Date 2018/6/8 16:07
 * @Version 1.0
 **/
@Service
public class MerchantorpersonCheckInServiceImpl implements MerchantorpersonCheckInService {

    @Autowired
    private MerchantorpersonCheckInDao merchantorpersonCheckInDao;

    /**
     * 查询所有入驻信息
     * @param page
     * @return
     */
    @Override
    public PageInfo<MerchantorpersonCheckIn> findByPage(PageRequest page) {
        try {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
            List<MerchantorpersonCheckIn> users = merchantorpersonCheckInDao.findByPage();
            PageInfo<MerchantorpersonCheckIn> pageInfo = new PageInfo<>(users);
            return pageInfo;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 商家入驻
     * @param merchantorpersonCheckIn
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public int insertMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn) {
        try {
            return merchantorpersonCheckInDao.insertMerchantorpersonCheckIn(merchantorpersonCheckIn);
        }catch (Exception e){
            e.printStackTrace();
            return 1001;
        }
    }

    /**
     * 按条件查询入驻信息
     * @param merchantorpersonCheckIn
     * @return
     */
    @Override
    public PageInfo<MerchantorpersonCheckIn> byConditionsQuery(PageRequest page,MerchantorpersonCheckIn merchantorpersonCheckIn) {
        try{
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
            List<MerchantorpersonCheckIn> users = merchantorpersonCheckInDao.byConditionsQuery(merchantorpersonCheckIn);
            PageInfo<MerchantorpersonCheckIn> pageInfo = new PageInfo<>(users);
            return pageInfo;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
