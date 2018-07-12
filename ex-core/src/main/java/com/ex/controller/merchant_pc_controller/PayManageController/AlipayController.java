package com.ex.controller.merchant_pc_controller.PayManageController;


import com.ex.service.PcAlipayService;
import com.ex.util.RandomUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/AlipayController")
public class AlipayController {

    @Autowired
    private PcAlipayService pcAlipayService;

    @RequestMapping("PcAlipay")
    public void PcAlipay(HttpServletRequest request, HttpServletResponse response,String total_amount, String subject, String body){
        try {
            String out_trade_no = RandomUtil.getRandomFileName();
            System.out.println("订单号----"+out_trade_no);
            String form = pcAlipayService.PcAlipay(out_trade_no, total_amount, subject, body);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(form);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**/