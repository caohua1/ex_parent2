package com.ex.service.impl;

import com.ex.dao.MerchantorpersonCheckInDao;
import com.ex.entity.MerchantorpersonCheckIn;
import com.ex.service.MerchantorpersonCheckInService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ProjectName ex_parent
 * @ClassName MerchantorpersonCheckInServiceImpl
 * @Description TODO
 * @Author sanmu
 * @Date 2018/6/8 16:07
 * @Version 1.0
 **/
public class MerchantorpersonCheckInServiceImpl implements MerchantorpersonCheckInService {

    @Autowired
    private MerchantorpersonCheckInDao merchantorpersonCheckInDao;

    @Override
    public PageInfo<MerchantorpersonCheckIn> findByPage(PageRequest page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<MerchantorpersonCheckIn> users = merchantorpersonCheckInDao.findByPage();
        PageInfo<MerchantorpersonCheckIn> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public int insertMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn) {
        return 0;
    }
}
