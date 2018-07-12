package com.ex.dao;

import com.ex.entity.ReportVideo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportVideoDao {

    public int insertReportVideo(ReportVideo reportVideo);

}
