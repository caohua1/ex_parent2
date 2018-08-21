package com.ex.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import com.ex.service.PcAlipayService;
import com.ex.util.AlipayConfig;

import java.io.IOException;

import static org.apache.catalina.manager.Constants.CHARSET;
@Service
public class PcAlipayServiceimpl implements PcAlipayService {


    /**
     * 支付宝电脑网站支付功能
     * @param out_trade_no
     * @param total_amount
     * @param subject
     * @param body
     * @throws IOException
     */
    @Override
    public String PcAlipay(String out_trade_no, String total_amount, String subject, String body) throws IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", CHARSET, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://ljxtvw2.hk1.mofasuidao.cn/AlipayReturnController/PcAlipayReturn");
        alipayRequest.setNotifyUrl("http://ljxtvw2.hk1.mofasuidao.cn/AlipayNotifyController/PcAlipayNotify");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+out_trade_no+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":"+total_amount+"," +
                "    \"subject\":\""+subject+"\"," +
                "    \"body\":\""+body+"\"" +
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }
}
