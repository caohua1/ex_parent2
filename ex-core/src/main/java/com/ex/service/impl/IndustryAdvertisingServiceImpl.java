package com.ex.service.impl;
import com.ex.dao.IndustryAdvertisingDao;
import com.ex.entity.IndustryAdvertising;
import com.ex.service.IndustryAdvertisingService;
import com.ex.util.PageRequest;
import com.ex.vo.IndustryAdvertisingVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class IndustryAdvertisingServiceImpl implements IndustryAdvertisingService {

    @Autowired
    private IndustryAdvertisingDao industryAdvertisingDao;

    /**
     * 添加行业分类广告
     * @param industryAdvertising
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer insertIndustryAdvertising(IndustryAdvertising industryAdvertising) {
        return industryAdvertisingDao.insertIndustryAdvertising(industryAdvertising);
    }


    /**
     * 分页查询行业分类广告
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<IndustryAdvertisingVo> selectIndustryAdvertising(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<IndustryAdvertisingVo> industryAdvertisingVos = industryAdvertisingDao.selectIndustryAdvertising();
        PageInfo<IndustryAdvertisingVo> pageInfo = new PageInfo<>(industryAdvertisingVos);
        return pageInfo;
    }


    /**
     * 查询总数量
     * @return
     */
    @Override
    public Integer selectIndustryAdvertisingCount() {
        return industryAdvertisingDao.selectIndustryAdvertisingCount();
    }

    /**
     * 编辑行业分类广告
     * @param industryAdvertising
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer updateIndustryAdvertising(IndustryAdvertising industryAdvertising) {
        return industryAdvertisingDao.updateIndustryAdvertising(industryAdvertising);
    }

    /**
     * 查询某行业分类的详情Id
     * @param id
     * @return
     */
    @Override
    public IndustryAdvertisingVo selectIndustryAdvertisingById(Long id) {
        return industryAdvertisingDao.selectIndustryAdvertisingById(id);
    }
}
