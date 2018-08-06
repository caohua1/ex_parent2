package com.ex.controller;

import com.aliyuncs.exceptions.ClientException;
import com.ex.util.ALiYunUtil;
import com.ex.util.CustomMD5;
import com.ex.util.JsonView;
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
        JsonView jsonView = new JsonView();
        try {
            //发送验证码
            String code = ALiYunUtil.sendSMS(phone,null,null,1);
            System.out.println(sf.format(new Date()));
            if (code == null) {
                jsonView.setMessage("短信验证码发送失败");
                jsonView.setCode(JsonView.ERROR);
                return jsonView;
            }
            //对验证码进行自定义加密
            String hashcose = CustomMD5.passwordAndSalt(KEY+"wh"+code, phone, 10);
            Calendar c = Calendar.getInstance();
            //生成5分钟后的时间
            c.add(Calendar.MINUTE, 5);
            String currentTime = sf.format(c.getTime());

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("hashcose", hashcose);
            resultMap.put("tamp", currentTime);
            jsonView.setData(resultMap);
            jsonView.setMessage("短信验证码发送成功！");
            jsonView.setCode(JsonView.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * @return
     * @Description TODO 检验验证码
     */
    @RequestMapping(value = "/checkSMS",method = RequestMethod.POST)
    public JsonView checkSMS(String hashcose,String tamp,String phone,String code) {
        JsonView jsonView = new JsonView();
        try {
            String requestHash = CustomMD5.passwordAndSalt(KEY+"wh"+code, phone, 10);
            Calendar c = Calendar.getInstance();
            if (tamp.compareTo(sf.format(new Date())) > 0) {
                if (!hashcose.equalsIgnoreCase(requestHash)) {
                    jsonView.setMessage("验证码错误!");
                    jsonView.setCode(JsonView.ERROR);
                    return jsonView;
                }
            } else {
                jsonView.setMessage("验证码超时!");
                jsonView.setCode(JsonView.EXPIRED);
                return jsonView;
            }
            jsonView.setMessage("验证成功!");
            jsonView.setCode(JsonView.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }
}