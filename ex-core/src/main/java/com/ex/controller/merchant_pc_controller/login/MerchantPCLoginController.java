package com.ex.controller.merchant_pc_controller.login;

import com.ex.entity.MerchantRegist;
import com.ex.service.MerchantRegistService;
import com.ex.util.CustomMD5;
import com.ex.util.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ProjectName ex_parent
 * @ClassName MerchantLoginController
 * @Description TODO 商家登陆注册接口
 * @Author sanmu
 * @Version 1.0
 **/
@RestController
@RequestMapping("/merchantPC/login")
public class MerchantPCLoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String KEY = "merchant"; // KEY为自定义秘钥
    private SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");

    @Autowired
    private MerchantRegistService merchantRegistService;

    /**
     * 商家注册
     *
     * @param merchantRegist
     * @return
     */
    @RequestMapping(path = "/merchantRegist", method = RequestMethod.POST)
    public JsonView merchantInsert(MerchantRegist merchantRegist,String hashcose,String tamp,String phone,String code) {
        JsonView jsonView = new JsonView();
        try {
            String requestHash = CustomMD5.passwordAndSalt(KEY+"wh"+code, phone, 15);
            Calendar c = Calendar.getInstance();
            if (tamp.compareTo(sf.format(new Date())) > 0) {
                if (!hashcose.equalsIgnoreCase(requestHash)) {
                    jsonView.setMessage("验证码错误！");
                    jsonView.setCode(JsonView.ERROR);
                    return jsonView;
                }
            } else {
                jsonView.setMessage("验证码超时!");
                jsonView.setCode(JsonView.ERROR);
                return jsonView;
            }
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



}
