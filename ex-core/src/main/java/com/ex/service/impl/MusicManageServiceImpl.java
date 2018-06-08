package com.ex.service.impl;

import com.ex.dao.MusicManageDao;
import com.ex.entity.MusicManage;

import com.ex.service.MusicManageService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicManageServiceImpl implements MusicManageService {

    @Autowired
    private MusicManageDao musicManageDao;

    /**
     * 查询音乐列表全部数据
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
     * 给音乐列表添加数据
     * @param musicManage
     * @return
     */
    @Override
    public int addMusicManage(MusicManage musicManage) {
        return musicManageDao.addMusicManage(musicManage);
    }
}
