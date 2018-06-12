package com.ex.dao;

import com.ex.entity.BusinessLicenseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessLicenseInfoDao {
    /**
     * 查询所有身份证信息
     * @return
     */
    List<BusinessLicenseInfo> findByPage();

    /**
     * 添加身份证信息
     * @param businessLicenseInfo
     * @return
     */
    int insertBusinessLicenseInfo(BusinessLicenseInfo businessLicenseInfo);

    /**
     * 按条件查询
     * @param businessLicenseInfo
     * @return
     */
    List<BusinessLicenseInfo> byConditionsQuery(@Param("businessLicenseInfo") BusinessLicenseInfo businessLicenseInfo);
}
