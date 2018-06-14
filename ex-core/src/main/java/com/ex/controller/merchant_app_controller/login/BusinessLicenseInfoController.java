package com.ex.controller.merchant_app_controller.login;

import com.ex.entity.BusinessLicenseInfo;
import com.ex.service.BusinessLicenseInfoService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/merchant/certification")
public class BusinessLicenseInfoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private BusinessLicenseInfoService businessLicenseInfoService;

    @RequestMapping("/upload")
    public JsonView insertBusinessLicenseInfo(MultipartFile[] files, MultipartFile idCardImage, MultipartFile businessImage, HttpServletRequest request, BusinessLicenseInfo businessLicenseInfo) {
        try {
            int code = businessLicenseInfoService.insertBusinessLicenseInfo(files,idCardImage,businessImage,request,businessLicenseInfo);
            if(code==1001){
                return JsonView.fail("提交失败，请重新上传!");
            }else if(code==1002){
                return  JsonView.fail("营业执照有遮挡，请重新上传!");
            }else if(code==1003){
                return  JsonView.fail("身份证模糊，请重新上传!");
            }
            return JsonView.success("提交成功!");
        }catch (Exception e){
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED,"服务器错误!");
        }
    }

    /**
     * 获取所有认证信息
     *
     * @param page
     * @return
     */
    @RequestMapping("/all")
    public JsonView findAll(PageRequest page) {
        try {
            logger.info("Request comming to find user list...");
            PageInfo<BusinessLicenseInfo> pageInfo = businessLicenseInfoService.findByPage(page);
            return JsonView.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
    }

}
