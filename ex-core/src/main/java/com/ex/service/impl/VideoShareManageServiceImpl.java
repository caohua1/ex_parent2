package com.ex.service.impl;

import com.ex.dao.VideoShareManageDao;
import com.ex.entity.MerchantorpersonUploadProduct;
import com.ex.entity.VideoShareManage;
import com.ex.service.VideoShareManageService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class VideoShareManageServiceImpl implements VideoShareManageService {

    @Autowired
    private VideoShareManageDao videoShareManageDao;
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
}
