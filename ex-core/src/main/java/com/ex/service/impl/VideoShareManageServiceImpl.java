package com.ex.service.impl;

import com.ex.dao.PCvideoShareManageDao;
import com.ex.dao.VideoShareManageDao;
import com.ex.entity.MerchantorpersonUploadProduct;
import com.ex.entity.VideoShareManage;
import com.ex.service.VideoShareManageService;
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
public class VideoShareManageServiceImpl implements VideoShareManageService {

    @Autowired
    private VideoShareManageDao videoShareManageDao;
    @Autowired
    private PCvideoShareManageDao pCvideoShareManageDao;
    /**
     * 视享管理（条件查询）加分页
     * @param termMap
     * @return
     */
    @Override
    public PageInfo<VideoShareManage> selectVideoShareManage(PageRequest page, Map termMap) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<VideoShareManage> videoShareManages = videoShareManageDao.selectVideoShareManage(termMap);
        PageInfo<VideoShareManage> pageInfo = new PageInfo<>(videoShareManages);
        return pageInfo;
    }

    /**
     * 查询数据数量
     * @param termMap
     * @return
     */
    @Override
    public Integer selectVideoShareManageCount(Map termMap) {
        return videoShareManageDao.selectVideoShareManageCount(termMap);
    }

    /**
     * PC端商家视享管理
     * @param page
     * @param termMap
     * @return
     */
    @Override
    public PageInfo<VideoShareManage> selectPCvideoShareManage(PageRequest page, Map termMap) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<VideoShareManage> videoShareManages = pCvideoShareManageDao.selectPCvideoShareManage(termMap);
        PageInfo<VideoShareManage> pageInfo = new PageInfo<>(videoShareManages);
        return pageInfo;
    }

    /**
     * 查询PC端商家数量
     * @param termMap
     * @return
     */
    @Override
    public Integer selectPCvideoShareManageCount(Map termMap) {
        return pCvideoShareManageDao.selectPCvideoShareManageCount(termMap);
    }

    /**
     *根据uid(商家上传文件信息id)，删除
     * @param uid
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer deletePCvideoShareManage(Long uid) {
        return pCvideoShareManageDao.deletePCvideoShareManage(uid);
    }
}
