package com.ex.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

/**
 * @ProjectName ex_parent
 * @ClassName SMSUtil
 * @Description TODO
 * @Author sanmu
 * @Date 2018/6/4 16:52
 * @Version 1.0
 **/
public class SMSUtil {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAI9n20XET2otjN";
    static final String accessKeySecret = "q7QM9FIlYVO9gaSkzxfmdK3mn237Ie";

    // TODO 签名和模板（在阿里云访问控制台寻找）
    static final String signName = "二享";
    static final String TemplateCode1 = "SMS_136720102";
    static final String TemplateCode2 = "SMS_136720102";

    // TODO KEY为自定义秘钥
    private static final String KEY = "abc123";

    /**
     *
     * @param phone 待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码
     * @return
     * @throws ClientException
     */
    public static String sendSMS(String phone) throws ClientException {
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setMethod(MethodType.POST);
        request.setPhoneNumbers(phone);
        request.setSignName(signName);
        request.setTemplateCode(TemplateCode1);
        String code = MathUtil.getRandom(6);
        request.setTemplateParam("{\"code\":\""+code+"\"}");
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        request.setOutId("yourOutId");
        //请求失败这里会抛ClientException异常
        try{
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                System.out.println("验证码为=============>"+code);
                return code;
            }
        }catch (ClientException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
