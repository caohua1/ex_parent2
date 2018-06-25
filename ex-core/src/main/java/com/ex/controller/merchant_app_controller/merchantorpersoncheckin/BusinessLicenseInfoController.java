package com.ex.controller.merchant_app_controller.merchantorpersoncheckin;

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

@RestController
@RequestMapping("/merchant/certification")
public class BusinessLicenseInfoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BusinessLicenseInfoService businessLicenseInfoService;

    /**
     * 获取所有认证信息
     *
     * @param page
     * @return
     */
    @RequestMapping("/all")
    public JsonView findAll(PageRequest page) {
        JsonView jsonView = new JsonView();
        try {
            logger.info("Request comming to find businessLicenseInfo list...");
            PageInfo<BusinessLicenseInfo> pageInfo = businessLicenseInfoService.findByPage(page);
            jsonView.setMessage("查询数据成功");
            jsonView.setData(pageInfo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setTodoCount(pageInfo.getSize());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
        return jsonView;
    }

    /**
     * 按条件查询认证信息
     * @param page
     * @param businessLicenseInfo
     * @return
     */
    @RequestMapping("/ConditionsQuery")
    public JsonView byConditionsQuery(PageRequest page,BusinessLicenseInfo businessLicenseInfo){
        try {
            logger.info("Request comming to by conditions query");
            PageInfo<BusinessLicenseInfo> pageInfo = businessLicenseInfoService.byConditionsQuery(page,businessLicenseInfo);
            return JsonView.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
    }

}