package com.ex.controller.merchant_pc_controller.PayManageController;

import com.ex.service.PaidlistProductService;
import com.ex.util.AlipayNotifyUrl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Action;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * pc端支付宝异步通知接口
 */
@Controller
@RequestMapping("/AlipayNotifyController")
public class AlipayNotifyController {

    @Autowired
    private PaidlistProductService paidlistProductService;

    @RequestMapping("PcAlipayNotify")
    public void PcAlipayNotify(HttpServletRequest request, HttpServletResponse response){
        AlipayNotifyUrl alipayNotifyUrl = new AlipayNotifyUrl();
        try {
            Map orderMap = alipayNotifyUrl.notifyUrl(request, response);
            //商户竞价排名订单号
            String outTradeNo = (String) orderMap.get("out_trade_no");
            //商户竞价排名支付宝交易号
            String tradeNo = (String) orderMap.get("trade_no");
            //商户竞价排名支付状态
            String tradeStatus = (String) orderMap.get("trade_status");
           if(tradeStatus.equals("TRADE_SUCCESS")){
               //根据订单号修改订单号状态做商户数据处理
               int i = paidlistProductService.updateState(outTradeNo);
               if(i>0){
                   try {
                       response.getWriter().write("success");
                       response.getWriter().flush();
                       response.getWriter().close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }else {
                   try {
                       response.getWriter().write("failure");
                       response.getWriter().flush();
                       response.getWriter().close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
