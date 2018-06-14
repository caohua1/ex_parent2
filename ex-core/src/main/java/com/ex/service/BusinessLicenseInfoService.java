package com.ex.service;

import com.ex.entity.BusinessLicenseInfo;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BusinessLicenseInfoService {
    /**
     * 查询所有身份证和营业执照信息
     * @return
     */
    PageInfo<BusinessLicenseInfo> findByPage(PageRequest page);

    /**
     * 添加身份证和营业执照信息
     * @param files
     * @param request
     * @param businessLicenseInfo
     * @return
     */
    int insertBusinessLicenseInfo(MultipartFile[] files, MultipartFile idCardImage, MultipartFile businessImage, HttpServletRequest request, BusinessLicenseInfo businessLicenseInfo);

    /**
     * 按条件查询
     * @param businessLicenseInfo
     * @return
     */
    List<com.ex.entity.BusinessLicenseInfo> byConditionsQuery(BusinessLicenseInfo businessLicenseInfo);
}
