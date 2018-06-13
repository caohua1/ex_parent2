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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
     * @param files
     * @param request
     * @param businessLicenseInfo
     * @return
     */
    @Override
    public int insertBusinessLicenseInfo(MultipartFile[] files, MultipartFile idCardImage, MultipartFile businessImage, HttpServletRequest request, BusinessLicenseInfo businessLicenseInfo) {
        FileEntity entity = new FileEntity();
        FileUploadTool fileUploadTool = new FileUploadTool();
        Map<String, String> businessMap;

        try {
            /////////////////
            if (businessImage != null) {
                entity = fileUploadTool.createFile(businessImage, request);
                System.out.println("返回报文---" + entity);
                businessMap = BaiduOcrtools.business(entity.getPath());
                businessLicenseInfo.setCompanyname(businessMap.get("单位名称"));
                businessLicenseInfo.setLegalperson(businessMap.get("法人"));
                businessLicenseInfo.setSocialcreditcode(businessMap.get("社会信用代码"));
                businessLicenseInfo.setValidityperiod(businessMap.get("有效期"));
                businessLicenseInfo.setCompanyaddress(businessMap.get("地址"));
                businessLicenseInfo.setMerchantidnumber(businessMap.get("证件编号"));
                businessLicenseInfo.setEstablishmentdate(businessMap.get("成立日期"));
                if (businessLicenseInfo.getCompanyname().equals("无") ||
                        businessLicenseInfo.getLegalperson().equals("无") ||
                        businessLicenseInfo.getSocialcreditcode().equals("无") ||
                        businessLicenseInfo.getValidityperiod().equals("无") ||
                        businessLicenseInfo.getCompanyaddress().equals("无") ||
                        businessLicenseInfo.getMerchantidnumber().equals("无") ||
                        businessLicenseInfo.getEstablishmentdate().equals("无")) {
                    // 1002营业执照有遮挡
                    return 1002;
                }
            } else {
                //1001图片上传失败
                return 1001;
            }
            if (idCardImage != null) {
                entity = fileUploadTool.createFile(idCardImage, request);
                if (entity != null) {
                    System.out.println("返回报文---" + entity);
                    businessMap = BaiduOcrtools.idCard(entity.getPath());
                    businessLicenseInfo.setRealname(businessMap.get("姓名"));
                    businessLicenseInfo.setIdcard(businessMap.get("公民身份号码"));
                    businessLicenseInfo.setBirthday(businessMap.get("出生"));
                    businessLicenseInfo.setSex(businessMap.get("性别") == "男" ? 1 : 0);
                    businessLicenseInfo.setAddress(businessMap.get("地址"));
                    businessLicenseInfo.setNational(businessMap.get("民族"));
                    if (businessLicenseInfo.getRealname().equals("无") ||
                            businessLicenseInfo.getIdcard().equals("无") ||
                            businessLicenseInfo.getBirthday().equals("无") ||
                            businessLicenseInfo.getSex().equals("无") ||
                            businessLicenseInfo.getAddress().equals("无") ||
                            businessLicenseInfo.getNational().equals("无")) {
                        // 1003身份证有遮挡
                        return 1003;
                    }
                } else {
                    return 1001;
                }
                //////////////////////////////
                for (int i = 0; 1 < files.length; i++) {
                    if (i == 0) {

                    } else {
                        entity = fileUploadTool.createFile(files[i], request);
                        if (entity == null) {
                            System.out.println("返回报文---" + entity);
                        } else {
                            return 1001;
                        }
                    }
                }
                businessLicenseInfoDao.insertBusinessLicenseInfo(businessLicenseInfo);

            }
            return 200;
        } catch (Exception e) {
            e.printStackTrace();
            return 1001;
        }
    }

        /**
         * 按条件查询
         *
         * @param businessLicenseInfo
         * @return
         */
        @Override
        public List<BusinessLicenseInfo> byConditionsQuery (BusinessLicenseInfo businessLicenseInfo){
            try {
                return businessLicenseInfoDao.byConditionsQuery(businessLicenseInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

}
