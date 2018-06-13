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

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/merchant/certification")
public class BusinessLicenseInfoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private BusinessLicenseInfoService businessLicenseInfoService;

    @RequestMapping("/all")
    public JsonView test(PageRequest page){

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
