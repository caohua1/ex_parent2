package com.ex.service;

import com.ex.entity.VideoShareManage;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;


import java.util.Map;

public interface VideoShareManageService {


    public PageInfo<VideoShareManage> selectVideoShareManage(PageRequest page, Map termMap);

    public Integer selectVideoShareManageCount(Map termMap);

    public PageInfo<VideoShareManage> selectPCvideoShareManage(PageRequest page, Map termMap);

    public Integer selectPCvideoShareManageCount(Map termMap);

    public Integer deletePCvideoShareManage(Long uid);

}
