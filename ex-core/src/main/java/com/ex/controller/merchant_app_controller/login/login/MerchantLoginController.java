package com.ex.controller.merchant_app_controller.login.login;

import com.ex.entity.MerchantRegist;
import com.ex.service.MerchantRegistService;
import com.ex.util.CustomMD5;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.util.TokenUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
     * 检查手机号是否已经注册
     *
     * @param username 用户名
     * @return
     */
    @RequestMapping("/checkMerchantName")
    public JsonView checkMerchantName(String username) {
        JsonView jsonView = new JsonView();
        try {
            logger.info("Request comming to Check username");
            MerchantRegist user = merchantRegistService.merchantLoginOrCheckUserName(username);
            if (user != null){
                jsonView.setMessage("手机号已存在");
                jsonView.setCode(JsonView.ERROR);
                return jsonView;
            }
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("手机号可用");
            jsonView.setTodoCount(1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 商家注册
     *
     * @param merchantRegist
     * @return
     */
    @RequestMapping(path = "/merchantRegist", method = RequestMethod.POST)
    public JsonView merchantInsert(MerchantRegist merchantRegist) {
        JsonView jsonView = new JsonView();
        try {
            merchantRegist.setStatus(1);
            logger.info("Request comming to regist user");
            MerchantRegist user = merchantRegistService.merchantLoginOrCheckUserName(merchantRegist.getUsername());
            if (user != null) {
                jsonView.setMessage("用户名已存在");
                jsonView.setCode(JsonView.ERROR);
                return jsonView;
            }
            merchantRegist.setRegisttime(new Date());
            merchantRegistService.insertMerchantRegist(merchantRegist);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("注册成功!");
            jsonView.setTodoCount(1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 商家登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(path = "/merchantLogin", method = RequestMethod.POST)
    public JsonView merchantLogin(String username, String password) {
        JsonView jsonView = new JsonView();
        try {
            logger.info("Request comming to Login user");
            MerchantRegist merchantRegist = merchantRegistService.merchantLoginOrCheckUserName(username);
            if (merchantRegist == null){
                jsonView.setMessage("用户名不存在");
                jsonView.setCode(JsonView.ERROR);
                return jsonView;
            }
            if (!CustomMD5.checkPassword(merchantRegist.getPassword(), password, username)) {
                jsonView.setMessage("密码不正确");
                jsonView.setCode(JsonView.ERROR);
                return jsonView;
            }
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("登陆成功!");
            Map<String, Object> map = new HashMap<>();
            String token = TokenUtil.MerchantToken(username, password, merchantRegist);
            map.put("token", token);
            map.put("merchant", merchantRegist);
            jsonView.setData(map);
            jsonView.setTodoCount(1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 查询所有商家注册信息
     *
     * @param page 分页
     * @return
     */
    @RequestMapping("/all")
    public JsonView findAll(PageRequest page) {
        JsonView jsonView = new JsonView();
        try {
            logger.info("Request comming to find user list...");
            PageInfo<MerchantRegist> pageInfo = merchantRegistService.findByPage(page);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求数据成功!");
            jsonView.setData(pageInfo);
            jsonView.setTodoCount(pageInfo.getSize());
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

}
