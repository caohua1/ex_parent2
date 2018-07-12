package com.ex.service;

import com.ex.entity.MusicManage;
import com.ex.entity.MyUploadFile;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface MyUploadFileService {

    public int insertMyUploadFile(MyUploadFile MyUploadFile);

    public PageInfo<MusicManage> selectMusicManage(PageRequest page);

    public PageInfo<MyUploadFile> selectListMyUploadFile(PageRequest page,Map factorMap);
}
