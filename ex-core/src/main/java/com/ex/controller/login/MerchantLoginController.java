package com.ex.controller.login;

import com.ex.entity.MerchantRegist;
import com.ex.service.MerchantRegistService;
import com.ex.util.CustomMD5;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName ex_parent
 * @ClassName MerchantLoginController
 * @Description TODO 商家登陆注册接口
 * @Author sanmu
 * @Version 1.0
 **/
@RestController
@RequestMapping("/merchant/login")
public class MerchantLoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MerchantRegistService merchantRegistService;

    /**
     * @param username 用户名
     * @return
     * @Desription TODO 检查手机号是否已经注册
     */
    @RequestMapping("/checkMerchantName")
    public JsonView checkMerchantName(String username) {
        try {
            logger.info("Request comming to Check username");
            MerchantRegist user = merchantRegistService.merchantLoginOrCheckUserName(username);
            if (user != null)
                return JsonView.fail(JsonView.ERROR, "手机号已存在");
            return JsonView.success("手机号可用");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
    }

    /**
     * @return com.ex.util.JsonView
     * @author sanmu
     * @Desription TODO 商家注册
     * @Param [merchantRegist] 用户对象
     **/
    @RequestMapping(path = "/merchantRegist", method = RequestMethod.POST)
    public JsonView merchantInsert(MerchantRegist merchantRegist) {
        try {
            merchantRegist.setStatus(1);
            logger.info("Request comming to regist user");
            JsonView view = new JsonView();
            MerchantRegist user = merchantRegistService.merchantLoginOrCheckUserName(merchantRegist.getUsername());
            if (user != null) {
                return JsonView.fail(JsonView.ERROR, "用户名已存在");
            }
            merchantRegistService.insertMerchantRegist(merchantRegist);
            return JsonView.success("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @return
     * @Desription TODO 商家登陆
     */
    @RequestMapping(path = "/merchantLogin", method = RequestMethod.POST)
    public JsonView merchantLogin(String username, String password) {
        try {
            logger.info("Request comming to Login user");
            MerchantRegist user = merchantRegistService.merchantLoginOrCheckUserName(username);
            if (user == null)
                return JsonView.fail(JsonView.ERROR, "用户名不存在");
            if (!CustomMD5.checkPassword(user.getPassword(), password, username))
                return JsonView.fail(JsonView.ERROR, "密码不正确");
            return JsonView.success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
    }

    /**
     * @param page 分页
     * @return
     * @Desription TODO 查询所有商家注册信息
     */
    @RequestMapping("/all")
    public JsonView findAll(PageRequest page) {
        try {
            logger.info("Request comming to find user list...");
            PageInfo<MerchantRegist> pageInfo = merchantRegistService.findByPage(page);
            return JsonView.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
    }

}
