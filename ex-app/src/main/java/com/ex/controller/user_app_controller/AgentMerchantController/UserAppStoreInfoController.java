package com.ex.controller.user_app_controller.AgentMerchantController;

import com.ex.service.UserAppStoreInfoService;
import com.ex.util.JsonView;
import com.ex.vo.UserAppAgentStoreInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/AgentMerchant")
public class UserAppStoreInfoController {

    @Autowired
    private UserAppStoreInfoService userAppStoreInfoService;

    /**
     * 按商家ID查询用户APP可代理店铺的详细信息
     * @param merchantId
     * @return
     */
    @RequestMapping("/selectUserAppAgentStoreInfo")
    public JsonView selectUserAppAgentStoreInfo(Long merchantId) {
        JsonView jsonView = new JsonView();
        try {
            UserAppAgentStoreInfoVo userAppAgentStoreInfoVo = userAppStoreInfoService.selectUserAppAgentStoreInfo(merchantId);
            jsonView.setData(userAppAgentStoreInfoVo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求成功!");
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }


}
