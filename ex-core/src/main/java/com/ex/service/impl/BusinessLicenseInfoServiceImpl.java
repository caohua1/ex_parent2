package com.ex.service.impl;

import com.ex.dao.BusinessLicenseInfoDao;
import com.ex.entity.BusinessLicenseInfo;
import com.ex.service.BusinessLicenseInfoService;
import com.ex.util.BaiduOcrtools;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BusinessLicenseInfoServiceImpl implements BusinessLicenseInfoService {

    @Autowired
    private BusinessLicenseInfoDao businessLicenseInfoDao;

    /**
     * 查询所有身份证和营业执照信息
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
     * @param idCardPath
     * @param charterPicUrl
     * @param businessLicenseInfo
     * @return
     */
    @Override
    public int insertBusinessLicenseInfo(String idCardPath, String charterPicUrl, BusinessLicenseInfo businessLicenseInfo) {
        Map<String, String> businessMap;
        try {
            if (charterPicUrl != null) {
                businessMap = BaiduOcrtools.business(charterPicUrl);
                businessLicenseInfo.setCompanyname(businessMap.get("单位名称"));
                businessLicenseInfo.setLegalperson(businessMap.get("法人"));
                businessLicenseInfo.setSocialcreditcode(businessMap.get("社会信用代码"));
                businessLicenseInfo.setValidityperiod(businessMap.get("有效期"));
                businessLicenseInfo.setCompanyaddress(businessMap.get("地址"));
                businessLicenseInfo.setMerchantidnumber(businessMap.get("证件编号"));
                businessLicenseInfo.setEstablishmentdate(businessMap.get("成立日期"));
            }
            if (idCardPath != null) {
                businessMap = BaiduOcrtools.idCard(idCardPath);
                businessLicenseInfo.setRealname(businessMap.get("姓名"));
                businessLicenseInfo.setIdcard(businessMap.get("公民身份号码"));
                businessLicenseInfo.setBirthday(businessMap.get("出生"));
                businessLicenseInfo.setSex(businessMap.get("性别") == "男" ? 1 : 0);
                businessLicenseInfo.setAddress(businessMap.get("地址"));
                businessLicenseInfo.setNational(businessMap.get("民族"));
            }
            businessLicenseInfoDao.insertBusinessLicenseInfo(businessLicenseInfo);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 按条件查询
     * @param businessLicenseInfo
     * @return
     */
    @Override
    public List<BusinessLicenseInfo> byConditionsQuery(BusinessLicenseInfo businessLicenseInfo) {
        try {
            return businessLicenseInfoDao.byConditionsQuery(businessLicenseInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
