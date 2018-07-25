package com.ex.service.impl;

import com.ex.dao.IndexAdvertisingDao;
import com.ex.entity.IndexAdvertising;
import com.ex.service.IndexAdvertisingService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexAdvertisingServiceImpl implements IndexAdvertisingService {

    @Autowired
    private IndexAdvertisingDao indexAdvertisingDao;

    /**
     * 添加首页广告
     * @param indexAdvertising
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer insertAdvertising(IndexAdvertising indexAdvertising) {
        return indexAdvertisingDao.insertAdvertising(indexAdvertising);
    }

    /**
     * 分页查询所有广告
     * @return
     */
    @Override
    public PageInfo<IndexAdvertising> selectAdvertising(Map map,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<IndexAdvertising> indexAdvertisings = indexAdvertisingDao.selectAdvertising(map);
        PageInfo<IndexAdvertising> pageInfo = new PageInfo<>(indexAdvertisings);
        return pageInfo;
    }

    /**
     * 查询所有广告的数量
     * @return
     */
    @Override
    public Integer selectAdvertisingCount(Map map) {
        return indexAdvertisingDao.selectAdvertisingCount(map);
    }

    /**
     * 编辑首页广告信息
     * @param indexAdvertising
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer updateAdvertising(IndexAdvertising indexAdvertising) {
        return indexAdvertisingDao.updateAdvertising(indexAdvertising);
    }

    /**
     * 根据id查询广告详情
     * @param id
     * @return
     */
    @Override
    public IndexAdvertising selectAdvertisingById(Long id) {
        return indexAdvertisingDao.selectAdvertisingById(id);
    }
}
