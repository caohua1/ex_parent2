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

/**
 * 认证信息
 */

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
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 按条件查询认证信息
     * @param page
     * @param businessLicenseInfo 可选参数
     *                            id
     *                            type
     *                            merchantid
     *                            registuserid
     *                            companyname
     *                            legalperson
     *                            companyaddress
     *                            establishmentdate
     *                            validityperiod
     *                            merchantidnumber
     *                            socialcreditcode
     *                            idcard
     *                            realname
     *                            sex
     *                            birthday
     *                            address
     *                            national
     * @return
     */
    @RequestMapping("/ConditionsQuery")
    public JsonView byConditionsQuery(PageRequest page,BusinessLicenseInfo businessLicenseInfo){
        JsonView jsonView = new JsonView();
        try {
            logger.info("Request comming to by conditions query");
            PageInfo<BusinessLicenseInfo> pageInfo = businessLicenseInfoService.byConditionsQuery(page,businessLicenseInfo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求数据成功!");
            jsonView.setTodoCount(pageInfo.getSize());
            jsonView.setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

}