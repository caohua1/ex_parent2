package com.ex.dao;

import com.ex.entity.VideoShareManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PCvideoShareManageDao {

    /**
     * PC端商家视享管理（条件查询）
     * @param termMap
     * @return
     */
    public List<VideoShareManage> selectPCvideoShareManage(Map termMap);

    /**
     * 查询数据数量
     * @param termMap
     * @return
     */
    public Integer selectPCvideoShareManageCount(Map termMap);

    public Integer deletePCvideoShareManage(Long uid);

}
