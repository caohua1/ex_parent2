package com.ex.service.impl;

import com.ex.dao.BusinessLicenseInfoDao;
import com.ex.entity.BusinessLicenseInfo;
import com.ex.service.BusinessLicenseInfoService;
import com.ex.util.BaiduOcrtools;
import com.ex.util.FileUploadTool;
import com.ex.util.PageRequest;
import com.ex.vo.FileEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class BusinessLicenseInfoServiceImpl implements BusinessLicenseInfoService {

    @Autowired
    private BusinessLicenseInfoDao businessLicenseInfoDao;

    /**
     * 查询所有身份证和营业执照信息
     *
     * @return
     */
    @Override
    public PageInfo<BusinessLicenseInfo> findByPage(PageRequest page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<BusinessLicenseInfo> businessLicenseInfos = businessLicenseInfoDao.findByPage();
        PageInfo<BusinessLicenseInfo> pageInfo = new PageInfo<>(businessLicenseInfos);
        return pageInfo;
    }


    /**
     * 添加身份证和营业执照信息
     *
     * @param charterPicUrl
     * @param idCardPicUrl_Z
     * @param idCardPicUrl_F
     * @param idCardPic
     * @param request
     * @param businessLicenseInfo
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public Map<String, Object> insertBusinessLicenseInfo(MultipartFile charterPicUrl, MultipartFile idCardPicUrl_Z, MultipartFile idCardPicUrl_F, MultipartFile idCardPic, HttpServletRequest request, BusinessLicenseInfo businessLicenseInfo) {
        FileEntity entity = new FileEntity();
        FileUploadTool fileUploadTool = new FileUploadTool();
        Map<String, Object> ret = BaiduOcrtools.chackCertification(charterPicUrl, idCardPicUrl_Z, idCardPicUrl_F, idCardPic, request, businessLicenseInfo);
        String code = ret.get("code").toString();
        if (code.equals("1001")) {
            return ret;
        }
        if (code.equals("1002")) {
            return ret;
        }
        if (code.equals("1003")) {
            return ret;
        }
        businessLicenseInfo = (BusinessLicenseInfo) ret.get("businessLicenseInfo");
        businessLicenseInfoDao.insertBusinessLicenseInfo(businessLicenseInfo);
        return ret;
    }

    /**
     * 按条件查询
     *
     * @param businessLicenseInfo
     * @return
     */
    @Override
    public PageInfo<BusinessLicenseInfo> byConditionsQuery(PageRequest page, BusinessLicenseInfo businessLicenseInfo) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<BusinessLicenseInfo> businessLicenseInfos = businessLicenseInfoDao.byConditionsQuery(businessLicenseInfo);
        PageInfo<BusinessLicenseInfo> pageInfo = new PageInfo<>(businessLicenseInfos);
        return pageInfo;
    }

}
