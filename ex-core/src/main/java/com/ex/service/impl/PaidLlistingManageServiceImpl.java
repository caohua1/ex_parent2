package com.ex.service.impl;

import com.ex.dao.PaidLlistingManageDao;
import com.ex.entity.PaidLlistingManage;
import com.ex.service.PaidLlistingManageService;
import com.ex.util.PageRequest;
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
public class PaidLlistingManageServiceImpl implements PaidLlistingManageService {

    @Autowired
    private PaidLlistingManageDao paidLlistingManageDao;

    /**
     * 视享竞价排名管理（查询，条件查询）
     * @param page
     * @param conditionMap
     * @return
     */
    @Override
    public PageInfo<PaidLlistingManage> selectPaidLlisting(PageRequest page, Map conditionMap) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<PaidLlistingManage> paidLlistingManages = paidLlistingManageDao.selectPaidLlisting(conditionMap);
        PageInfo<PaidLlistingManage> pageInfo = new PageInfo<>(paidLlistingManages);
        return pageInfo;
    }

    /**
     * 视享竞价排名管理删除数据
     * @param id
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public int delectPaidLlisting(Long id) {
        return paidLlistingManageDao.delectPaidLlisting(id);
    }
}
