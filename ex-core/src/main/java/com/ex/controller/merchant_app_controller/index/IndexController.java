package com.ex.controller.merchant_app_controller.index;

import com.ex.service.MerchantIndexService;
import com.ex.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.jar.JarEntry;

@RequestMapping("/appMerchantIndex")
@RestController
public class IndexController {

    @Autowired
    private MerchantIndexService merchantIndexService;

    /**
     *  商家的个人资料(头像/企业名称/)/推广码
     *  商家可提现金额/冻结金额（订单产生但交易未完成）/已提现金额
     *  此商家 今日浏览量/用户量/七日订单量
     * @param merchantId (参数，商家id)
     * @return
     */
    @RequestMapping("/merchantIndex")
    public JsonView merchantIndex(Long merchantId){
        JsonView jsonView = new JsonView();
        try{
            Map<String, Object> merchantIndex = merchantIndexService.merchantIndex(merchantId);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(merchantIndex);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

}
