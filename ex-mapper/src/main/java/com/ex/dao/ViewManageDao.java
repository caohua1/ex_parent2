package com.ex.dao;

import com.ex.entity.ViewManage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ViewManageDao {

    /**
     * 给视图配置增加数据
     */
    public int addViewManage(ViewManage viewManage);
}
