package com.ex.service.impl;

import com.ex.dao.ReportVideoDao;
import com.ex.entity.ReportVideo;
import com.ex.service.ReportVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportVideoServiceimpl implements ReportVideoService {

    @Autowired
    private ReportVideoDao reportVideoDao;

    /**
     * 添加举报视频记录
     * @param reportVideo
     * @return
     */
    @Override
    public int insertReportVideo(ReportVideo reportVideo) {
        return reportVideoDao.insertReportVideo(reportVideo);
    }
}
