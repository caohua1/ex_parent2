package com.ex.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cloudauth.model.v20180703.*;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.HttpRequest;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.json.JSONObject;

import java.util.UUID;

/**
 * @ProjectName ex_parent
 * @ClassName SMSUtil
 * @Description TODO
 * @Author sanmu
 * @Date 2018/6/4 16:52
 * @Version 1.0
 **/
public class ALiYunUtil {

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
    static final String TemplateCode2 = "SMS_140115138";

    // TODO KEY为自定义秘钥
    private static final String KEY = "abc123";

    /**
     * @param phone 待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码
     * @return
     * @throws ClientException
     */
    public static String sendSMS(String phone, String content, String name, int state) throws ClientException {
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
        String code = null;
        if (state == 1) {
            request.setTemplateCode(TemplateCode1);
            code = MathUtil.getRandom(6);
            request.setTemplateParam("{\"code\":\"" + code + "\"}"); //短信验证码发送
        } else if (state == 2) {
            request.setTemplateCode(TemplateCode2);
            //你好：${name}，${content}
            request.setTemplateParam("{\"name\":\"" + name + "\",\"content\":\"" + content + "\"}");  //自定义短信发送
        }
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        request.setOutId("yourOutId");
        //请求失败这里会抛ClientException异常
        try {
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            return code;
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static boolean ALIBB_RPBasic(String url) {
        //创建DefaultAcsClient实例并初始化
        System.out.println("创建DefaultAcsClient实例并初始化");
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou",             //默认
                accessKeyId,         //您的Access Key ID
                accessKeySecret);    //您的Access Key Secret
        IAcsClient client = new DefaultAcsClient(profile);
        String biz = "MERCHANTORPERSON"; //您在控制台上创建的、采用RPBasic认证方案的认证场景标识, 创建方法：https://help.aliyun.com/document_detail/59975.html
        String ticketId = UUID.randomUUID().toString(); //认证ID, 由使用方指定, 发起不同的认证任务需要更换不同的认证ID
        System.out.println("生成认证ID：" + ticketId);
        String token = null; //认证token, 表达一次认证会话
        int statusCode = -1; //-1 未认证, 0 认证中, 1 认证通过, 2 认证不通过
        //1. 服务端发起认证请求, 获取到token
        // System.out.println("服务端发起认证请求, 获取到token");
        //GetVerifyToken接口文档：https://help.aliyun.com/document_detail/57050.html
        GetVerifyTokenRequest getVerifyTokenRequest = new GetVerifyTokenRequest();
        getVerifyTokenRequest.setBiz(biz);
        getVerifyTokenRequest.setTicketId(ticketId);
        try {
            GetVerifyTokenResponse response = client.getAcsResponse(getVerifyTokenRequest);
            token = response.getData().getVerifyToken().getToken(); //token默认30分钟时效，每次发起认证时都必须实时获取
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        System.out.println("生成token：" + token);
//        //2. 服务端将token传递给无线客户端
//        Httpclients httpclients = new Httpclients();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.append("token", token);
//        JSONObject jsonObject1 = httpclients.doPost(url, jsonObject);
        System.out.println("服务端将token传递给无线客户端");
        //3. 无线客户端用token调起无线认证SDK
        //4. 用户按照由无线认证SDK组织的认证流程页面的指引，提交认证资料
        //5. 认证流程结束退出无线认证SDK，进入客户端回调函数
        //6. 服务端查询认证状态(客户端回调中也会携带认证状态, 但建议以服务端调接口确认的为准)
        //GetStatus接口文档：https://help.aliyun.com/document_detail/57049.html
        GetStatusRequest getStatusRequest = new GetStatusRequest();
        getStatusRequest.setBiz(biz);
        getStatusRequest.setTicketId(ticketId);
        try {
            GetStatusResponse response = client.getAcsResponse(getStatusRequest);
            statusCode = response.getData().getStatusCode();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        //7. 服务端获取认证资料
        //GetMaterials接口文档：https://help.aliyun.com/document_detail/57641.html
        GetMaterialsRequest getMaterialsRequest = new GetMaterialsRequest();
        getMaterialsRequest.setBiz(biz);
        getMaterialsRequest.setTicketId(ticketId);
        if (1 == statusCode || 2 == statusCode) { //认证通过or认证不通过
            try {
                GetMaterialsResponse response = client.getAcsResponse(getMaterialsRequest);
                //后续业务处理
                if (statusCode == 1) {
                    System.out.println("认证通过");
                    return true;
                } else {
                    System.out.println("认证不通过");
                    return false;
                }
            } catch (ServerException e) {
                e.printStackTrace();
            } catch (ClientException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
