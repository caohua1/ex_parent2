package com.ex.service.impl;

import com.ex.dao.BusinessLicenseInfoDao;
import com.ex.entity.BusinessLicenseInfo;
import com.ex.service.BusinessLicenseInfoService;
import com.ex.util.BaiduOcrtools;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class BusinessLicenseInfoServiceImpl implements BusinessLicenseInfoService{

    @Autowired
    private BusinessLicenseInfoDao businessLicenseInfoDao;

    @Override
    public PageInfo<BusinessLicenseInfo> findByPage(PageRequest page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<BusinessLicenseInfo> businessLicenseInfos = businessLicenseInfoDao.findByPage();
        PageInfo<BusinessLicenseInfo> pageInfo = new PageInfo<>(businessLicenseInfos);
        return pageInfo;
    }


    @Override
    public int insertBusinessLicenseInfo(String path,Mer) {
        try {
            Map<String, String> businessMap = BaiduOcrtools.business(path);
            BusinessLicenseInfo =
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<BusinessLicenseInfo> byConditionsQuery(BusinessLicenseInfo businessLicenseInfo) {
        return null;
    }
}
