package com.ex.controller;

import com.aliyuncs.exceptions.ClientException;
import com.ex.util.CustomMD5;
import com.ex.util.JsonView;
import com.ex.util.SMSUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName ex_parent
 * @ClassName SMSUtil
 * @Description TODO 用户短信接口
 * @Author sanmu
 * @Date 2018/6/6 11:09
 * @Version 1.0
 **/
@RestController
@RequestMapping("/userapp/sms")
public class SMSController {

    private static final String KEY = "userapp"; // KEY为自定义秘钥
    private SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
    /**
     * @return
     * @Description TODO 发送验证码
     */
    @RequestMapping(value = "/sendSMS",method = RequestMethod.POST)
    public JsonView sendSMS(String phone) throws ClientException {
        try {
            //发送验证码
            String code = SMSUtil.sendSMS(phone);
            System.out.println(sf.format(new Date()));
            if (code == null)
                return JsonView.fail(JsonView.ERROR, "短信验证码发送失败！");
            //对验证码进行自定义加密
            String hashcose = CustomMD5.passwordAndSalt(KEY+"wh"+code, phone, 10);
            Calendar c = Calendar.getInstance();
            // 生成5分钟后的时间
            c.add(Calendar.MINUTE, 5);
            String currentTime = sf.format(c.getTime());

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("hashcose", hashcose);
            resultMap.put("tamp", currentTime);

            JsonView view = new JsonView();
            view.setData(resultMap);
            view.setMessage("短信验证码发送成功！");
            view.setCode(JsonView.SUCCESS);
            return view;
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
    }

    /**
     * @return
     * @Description TODO 检验验证码
     */
    @RequestMapping(value = "/checkSMS",method = RequestMethod.POST)
    public JsonView checkSMS(String hashcose,String tamp,String phone,String code) {
        String requestHash = CustomMD5.passwordAndSalt(KEY+"wh"+code, phone, 10);
        Calendar c = Calendar.getInstance();
        if (tamp.compareTo(sf.format(new Date())) > 0) {
            if (hashcose.equalsIgnoreCase(requestHash)) {
                return JsonView.success("验证成功！");
            } else {
                return JsonView.fail("验证码错误！");
            }
        } else {
            return JsonView.fail(JsonView.EXPIRED,"验证码超时!");
        }
    }
}