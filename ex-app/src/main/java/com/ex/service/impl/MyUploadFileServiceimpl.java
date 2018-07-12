package com.ex.service.impl;

import com.ex.dao.MusicManageDao;
import com.ex.dao.MyUploadFileDao;
import com.ex.entity.MusicManage;
import com.ex.entity.MyUploadFile;
import com.ex.service.MyUploadFileService;
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
public class MyUploadFileServiceimpl implements MyUploadFileService {

    @Autowired
    private MyUploadFileDao myUploadFileDao;
    @Autowired
    private MusicManageDao musicManageDao;

    /**
     * 用户App上传文件
     * @param MyUploadFile
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public int insertMyUploadFile(MyUploadFile MyUploadFile) {
        return myUploadFileDao.insertMyUploadFile(MyUploadFile);
    }

    /**
     * 用户选择背景音乐接口
     * @param page
     * @return
     */
    @Override
    public PageInfo<MusicManage> selectMusicManage(PageRequest page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<MusicManage> musicManages = musicManageDao.selectMusicManage();
        PageInfo<MusicManage> pageInfo = new PageInfo<>(musicManages);
        return pageInfo;
    }

    /**
     * 用户查询已发布视频效果
     * @param factorMap
     * @return
     */
    @Override
    public PageInfo<MyUploadFile> selectListMyUploadFile(PageRequest page,Map factorMap) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<MyUploadFile> myUploadFiles = myUploadFileDao.selectListMyUploadFile(factorMap);
        PageInfo<MyUploadFile> pageInfo = new PageInfo<>(myUploadFiles);
        return pageInfo;
    }
}
