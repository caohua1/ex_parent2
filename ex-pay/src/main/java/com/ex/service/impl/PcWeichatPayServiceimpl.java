package com.ex.service.impl;

import com.github.wxpay.sdk.WXPay;
import com.ex.service.PcWeichatPayService;
import com.ex.util.weixinPay.MyConfig;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class PcWeichatPayServiceimpl implements PcWeichatPayService {
//String body, String out_trade_no, String device_info, String fee_type, String total_fee, String spbill_create_ip, String notify_url, String trade_type, String product_id

    @Override
    public Map<String, String> PcWeichatPay() throws Exception {
        Map<String, String> resp = null;
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "腾讯充值中心-QQ会员充值");
        data.put("out_trade_no", "2016090910595900000013");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "192.168.1.10");
        data.put("notify_url", "http://ljxtvw2.hk1.mofasuidao.cn/WeiChatNotifyController/getWxPayNotify");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "12");
        try {
            resp = wxpay.unifiedOrder(data);
            System.out.println("返回值-----" + resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}

