package com.ex.controller.merchant_app_controller.index;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/appMerchantIndex")
@RestController
public class IndexController {
    //merchantId（公用的参数  ）
    //商家的个人资料(头像/企业名称/)
    //商家可提现金额/冻结金额（订单产生但交易未完成）/已提现金额
    //此商家 今日浏览量/用户量/七日订单量
}
