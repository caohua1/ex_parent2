package com.ex.service;

import com.ex.entity.BusinessLicenseInfo;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BusinessLicenseInfoService {
    /**
     * 查询所有营业执照信息
     * @return
     */
    PageInfo<BusinessLicenseInfo> findByPage(PageRequest page);

    /**
     * 添加营业执照信息
     * @param path
     * @return
     */
    int insertBusinessLicenseInfo(String path);

    /**
     * 按条件查询
     * @param businessLicenseInfo
     * @return
     */
    List<com.ex.entity.BusinessLicenseInfo> byConditionsQuery(com.ex.entity.BusinessLicenseInfo businessLicenseInfo);
}
