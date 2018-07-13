package com.ex.service.impl;

import com.ex.dao.IndustryClassifyDao;
import com.ex.dao.MerchantorpersonCheckInDao;
import com.ex.dao.StoreInfoDao;
import com.ex.entity.IndustryClassify;
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

import java.util.Date;
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

    @Autowired
    private IndustryClassifyDao industryClassifyDao;

    /**
     * 查询所有入驻信息
     *
     * @param page
     * @return
     */
    @Override
    public PageInfo<MerchantorpersonCheckIn> findByPage(PageRequest page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<MerchantorpersonCheckIn> users = merchantorpersonCheckInDao.findByPage();
        PageInfo<MerchantorpersonCheckIn> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    /**
     * 商家入驻
     *
     * @param merchantorpersonCheckIn
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int insertMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn) {
        return merchantorpersonCheckInDao.insertMerchantorpersonCheckIn(merchantorpersonCheckIn);
    }

    /**
     * 按条件查询入驻信息
     *
     * @param merchantorpersonCheckIn
     * @return
     */
    @Override
    public PageInfo<MerchantorpersonCheckIn> byConditionsQuery(PageRequest page, MerchantorpersonCheckIn merchantorpersonCheckIn) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<MerchantorpersonCheckIn> users = merchantorpersonCheckInDao.byConditionsQuery(merchantorpersonCheckIn);
        PageInfo<MerchantorpersonCheckIn> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    /**
     * 按注册人Id和入住类型查询
     * @param merchantId
     * @param checkInType
     * @return
     */
    @Override
    public MerchantorpersonCheckIn selectByMerchantId(Long merchantId, Integer checkInType) {
        MerchantorpersonCheckIn merchantorpersonCheckIn = merchantorpersonCheckInDao.selectByMerchantId(merchantId, checkInType);
        return merchantorpersonCheckIn;
    }

    /**
     * 修改入驻信息
     * @param merchantorpersonCheckIn
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int updateMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn) {
        return merchantorpersonCheckInDao.updateMerchantorpersonCheckIn(merchantorpersonCheckIn);
    }

    /**
     * 商家PC端审核
     * @param id
     * @param status
     * @param causeby
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int auditTheMerchant(long id, int status, String causeby, Date updateTime) {
        //审核商家
        return merchantorpersonCheckInDao.auditTheMerchant(id, status, causeby,updateTime);
    }

    /**
     * 查询所有可显示的行业分类信息
     * @return
     */
    @Override
    public List<IndustryClassify> getIndustryClassifyAll() {
        return industryClassifyDao.getAll();
    }
}