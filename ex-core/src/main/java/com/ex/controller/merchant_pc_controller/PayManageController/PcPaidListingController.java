package com.ex.controller.merchant_pc_controller.PayManageController;

import com.ex.entity.PaidlistProduct;
import com.ex.service.PaidlistProductService;
import com.ex.service.PcAlipayService;
import com.ex.util.JsonView;
import com.ex.util.RandomUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * pc版商家竞价排名
 */
@RestController
@RequestMapping("/PcPaidListingController")
    public class PcPaidListingController {

        @Autowired
        private PaidlistProductService paidlistProductService;

        @Autowired
        private PcAlipayService pcAlipayService;
    /**
     * pc端支付宝竞价排名接口
     * @param request
     * @param response
     * @param paidlistProduct
     * @return
     */
        @RequestMapping("alipayPaidListing")
        public void alipayPaidListing(HttpServletRequest request, HttpServletResponse response, PaidlistProduct paidlistProduct){
        Map conditionMap = new HashMap<String, Object>();
        String out_trade_no = RandomUtil.getRandomFileName();
        System.out.println("订单号----"+out_trade_no);
        try{
            if(paidlistProduct!=null){
                if(paidlistProduct.getMerchantId()!=null){
                    conditionMap.put("merchantId",paidlistProduct.getMerchantId());
                }if(paidlistProduct.getUploadProductId()!=null){
                    conditionMap.put("uploadProductId",paidlistProduct.getUploadProductId());
                }if(paidlistProduct.getType()==0){
                    conditionMap.put("type",paidlistProduct.getType());
                }else if(paidlistProduct.getType()==1){
                    conditionMap.put("type",paidlistProduct.getType());
                }else {
                    conditionMap.put("type",null);
                }if(paidlistProduct.getMoney()!=null){
                    conditionMap.put("money",paidlistProduct.getMoney());
                }
                conditionMap.put("orderNumber",out_trade_no);
                conditionMap.put("payWay",1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String format = simpleDateFormat.format(date);
                Date parse = simpleDateFormat.parse(format);
                conditionMap.put("createTime",parse);
            }
            int i = paidlistProductService.insertPaidlistProduct(conditionMap);
            if(i>0){
                String subject="qq";
                String body="ww";
                String form = pcAlipayService.PcAlipay(out_trade_no, "11", subject, body);
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write(form);//直接将完整的表单html输出到页面
                response.getWriter().flush();
                response.getWriter().close();
            }else {
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
