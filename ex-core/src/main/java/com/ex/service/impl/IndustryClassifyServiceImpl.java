package com.ex.service.impl;

import com.ex.dao.IndustryClassifyDao;
import com.ex.entity.IndustryClassify;
import com.ex.service.IndustryClassifyService;
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
public class IndustryClassifyServiceImpl implements IndustryClassifyService {

    @Autowired
    private IndustryClassifyDao industryClassifyDao;

    /**
     * 添加行业分类
     * @param industryClassify
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer insertIndustry(IndustryClassify industryClassify) {
        return industryClassifyDao.insertIndustry(industryClassify);
    }

    /**
     * 分页查询行业分类
     * @param industryClassify
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<IndustryClassify> selectIndustry(IndustryClassify industryClassify, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<IndustryClassify> industryClassifies = industryClassifyDao.selectIndustry(industryClassify);
        PageInfo<IndustryClassify> pageInfo = new PageInfo<>(industryClassifies);
        return pageInfo;
    }

    /**
     * 查询总数
     * @param industryClassify
     * @return
     */
    @Override
    public Integer selectIndustryCount(IndustryClassify industryClassify) {
        return industryClassifyDao.selectIndustryCount(industryClassify);
    }

    /**
     * 修改分类
     * @param industryClassify
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer updateIndustry(IndustryClassify industryClassify) {
        return industryClassifyDao.updateIndustry(industryClassify);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer deleteIndustry(Long id) {
        return industryClassifyDao.deleteIndustry(id);
    }
}
