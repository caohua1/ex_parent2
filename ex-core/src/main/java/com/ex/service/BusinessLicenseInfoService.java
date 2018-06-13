package com.ex.service;

import com.ex.entity.BusinessLicenseInfo;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BusinessLicenseInfoService {
    /**
     * 查询所有身份证和营业执照信息
     * @return
     */
    PageInfo<BusinessLicenseInfo> findByPage(PageRequest page);

    /**
     * 添加身份证和营业执照信息
     * @param idCardPath
     * @param charterPicUrl
     * @param businessLicenseInfo
     * @return
     */
    int insertBusinessLicenseInfo(String idCardPath,String charterPicUrl,BusinessLicenseInfo businessLicenseInfo);

    /**
     * 按条件查询
     * @param businessLicenseInfo
     * @return
     */
    List<com.ex.entity.BusinessLicenseInfo> byConditionsQuery(com.ex.entity.BusinessLicenseInfo businessLicenseInfo);
}
