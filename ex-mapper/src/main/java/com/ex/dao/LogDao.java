package com.ex.dao;

import com.ex.entity.Log;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogDao {
    /**
     * 添加日志
     * @param log
     * @return
     */
    public Integer insertLog(Log log);
}
