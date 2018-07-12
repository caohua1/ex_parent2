package com.ex.controller.merchant_app_controller.Pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.catalina.manager.Constants.CHARSET;

public class AppAlipay {

    public String pay(){

        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", AlipayConfig.ALIPAY_APPID, AlipayConfig.APP_PRIVATE_KEY, "json", CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, "RSA2");
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("我是测试数据");
        model.setSubject("App支付测试Java");
        model.setOutTradeNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*90000+10000));//更换为自己的订单编号
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.01");//订单价格
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl("商户外网可以访问的异步地址");//回调地址不可以带参数
        String orderStr = "";
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            orderStr = response.getBody();
            System.out.println(orderStr);//就是orderString 可以直接给客户端请求，无需再做处理。
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }
}
