package com.ex.controller.merchant_pc_controller.PayManageController;

import com.ex.util.AlipayReturnUrl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
@RequestMapping("AlipayReturnController")
public class AlipayReturnController {

    @RequestMapping("PcAlipayReturn")
    public void PcAlipayReturn(HttpServletRequest request, HttpServletResponse response){
        Map<String, String[]> requestParams = request.getParameterMap();
        AlipayReturnUrl alipayReturnUrl = new AlipayReturnUrl();
        try {
            alipayReturnUrl.reurnUrl(request,response,requestParams);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
