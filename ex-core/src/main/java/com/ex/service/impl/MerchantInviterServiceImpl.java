package com.ex.service.impl;

import com.ex.dao.MerchantInviterDao;
import com.ex.entity.MerchantInviter;
import com.ex.service.MerchantInviterService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MerchantInviterServiceImpl implements MerchantInviterService {

    @Autowired
    private MerchantInviterDao merchantInviterDao;

    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int insertMerchantInviter(MerchantInviter merchantInviter) {
        return merchantInviterDao.insertMerchantInviter(merchantInviter);
    }

    @Override
    public PageInfo<MerchantInviter> byConditionsQuery(PageRequest page, MerchantInviter merchantInviter) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<MerchantInviter> merchantInviters = merchantInviterDao.byConditionsQuery(merchantInviter);
        PageInfo<MerchantInviter> pageInfo = new PageInfo<>(merchantInviters);
        return pageInfo;
    }


    @Override
    public  MerchantInviter selectInvitercode(Long invitermerchantid) {
        return merchantInviterDao.selectByMerchantid(invitermerchantid);
    }

    @Override
    public MerchantInviter selectInvitercodeByInvitercode(Long invitercode) {
        return merchantInviterDao.selectByInvitercode(invitercode);
    }

    @Override
    public int updateInvitercode(MerchantInviter merchantInviter) {
        return merchantInviterDao.updateInvitercode(merchantInviter);
    }

}
