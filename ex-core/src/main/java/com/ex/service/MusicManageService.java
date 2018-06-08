package com.ex.service;

import com.ex.entity.MusicManage;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;


public interface MusicManageService {


    public PageInfo<MusicManage> selectMusicManage(PageRequest page);

    public int addMusicManage(MusicManage musicManage);
}
