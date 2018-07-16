package com.ex.controller.merchant_app_controller.mutualReferringManageController;

import com.ex.service.MerchantRegistService;
import com.ex.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mutualReferringController")
public class mutualReferringController {

    @Autowired
    private MerchantRegistService MerchantRegistService;

    /**
     * 互推设置接口
     * @return
     */
    @RequestMapping("ElectSet")
    public JsonView ElectSet(String username,Double commissionRate){
        JsonView jsonView = new JsonView();
        try{
            Long merchantId = MerchantRegistService.selectMutualReferrringById(username);

        }catch (Exception e) {
            e.printStackTrace();
            jsonView.fail();
        }
        return jsonView;
    }
}
