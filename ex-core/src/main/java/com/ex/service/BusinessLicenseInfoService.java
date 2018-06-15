package com.ex.service;

import com.ex.entity.BusinessLicenseInfo;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface BusinessLicenseInfoService {
    /**
     * 查询所有身份证和营业执照信息
     * @return
     */
    PageInfo<BusinessLicenseInfo> findByPage(PageRequest page);

    /**
     * 添加身份证和营业执照信息
     * @param charterPicUrl
     * @param idCardPicUrl_Z
     * @param idCardPicUrl_F
     * @param idCardPic
     * @param request
     * @param businessLicenseInfo
     * @return
     */
    Map<String,Object> insertBusinessLicenseInfo(MultipartFile charterPicUrl, MultipartFile idCardPicUrl_Z, MultipartFile idCardPicUrl_F,MultipartFile idCardPic, HttpServletRequest request, BusinessLicenseInfo businessLicenseInfo);

    /**
     * 按条件查询
     * @param businessLicenseInfo
     * @return
     */
    PageInfo<BusinessLicenseInfo> byConditionsQuery(PageRequest page,BusinessLicenseInfo businessLicenseInfo);
}
