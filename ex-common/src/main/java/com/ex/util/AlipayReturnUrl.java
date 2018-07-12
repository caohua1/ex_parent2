package com.ex.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 支付宝PC端网页支付同步返回工具类
 */
public class AlipayReturnUrl {

            public void reurnUrl(HttpServletRequest request, HttpServletResponse response,Map requestParams) throws UnsupportedEncodingException {
                //获取支付宝GET过来反馈信息
                Map<String,String> params = new HashMap<String,String>();
                for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
                    String name = (String) iter.next();
                    String[] values = (String[]) requestParams.get(name);
                    String valueStr = "";
                    for (int i = 0; i < values.length; i++) {
                        valueStr = (i == values.length - 1) ? valueStr + values[i]
                                : valueStr + values[i] + ",";
                    }
                    //乱码解决，这段代码在出现乱码时使用
                    valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                    params.put(name, valueStr);
                }

                boolean signVerified = false; //调用SDK验证签名
                try {
                    signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
                //——请在这里编写您的程序（以下代码仅作参考）——
                if(signVerified) {
                    //验签成功
                    //商户订单号
                    String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

                    //支付宝交易号
                    String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

                    //付款金额
                    String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
                }else {
                    //验签失败
                }
                } catch (AlipayApiException e) {
                    e.printStackTrace();
                }
            }
}
