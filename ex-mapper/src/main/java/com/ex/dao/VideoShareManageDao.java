package com.ex.dao;

import com.ex.entity.VideoShareManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface VideoShareManageDao {

    /**
     * 视享管理（条件查询）
     * @param termMap
     * @return
     */
    public List<VideoShareManage> selectVideoShareManage(Map termMap);

    /**
     * 查询数据数量
     * @param termMap
     * @return
     */
    public Integer selectVideoShareManageCount(Map termMap);
}
