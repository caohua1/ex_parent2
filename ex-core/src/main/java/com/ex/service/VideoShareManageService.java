package com.ex.service;

import com.ex.entity.VideoShareManage;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;


import java.util.Map;

public interface VideoShareManageService {


    public PageInfo<VideoShareManage> selectVideoShareManage(PageRequest page, Map termMap);

    public Integer selectVideoShareManageCount(Map termMap);
}
