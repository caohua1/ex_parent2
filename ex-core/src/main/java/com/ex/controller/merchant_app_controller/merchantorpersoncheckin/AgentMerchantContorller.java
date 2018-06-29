package com.ex.controller.merchant_app_controller.merchantorpersoncheckin;

import com.ex.entity.AgentMerchant;
import com.ex.service.AgentMerchantService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代理商家
 */
@RestController
@RequestMapping("/merchant/agentmerchant")
public class AgentMerchantContorller {

    @Autowired
    private AgentMerchantService agentMerchantService;

    /**
     * 代理商家
     * @param agentMerchant 可选参数
     *                      id
     *                      gentuserid
     *                      merchantid
     *                      productinfoid
     *                      agenttime
     *                      updatetime
     *                      status
     * @return
     */
    @RequestMapping(value = "/insertAgentMerchant",method = RequestMethod.POST)
    public JsonView insertAgentMerchant(AgentMerchant agentMerchant){
        JsonView jsonView = new JsonView();
        try {
            agentMerchantService.insertAgentMerchant(agentMerchant);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("代理成功!");
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 按条件查询代理商家信息
     * @param page
     * @param agentMerchant 可选参数
     *                      id
     *                      gentuserid
     *                      merchantid
     *                      productinfoid
     *                      agenttime
     *                      updatetime
     *                      status
     * @return
     */
    @RequestMapping("/byConditionsQuery")
    public JsonView byConditionsQuery(PageRequest page,AgentMerchant agentMerchant){
        JsonView jsonView = new JsonView();
        try {
            PageInfo<AgentMerchant> pageInfo = agentMerchantService.byConditionsQuery(page, agentMerchant);
            jsonView.setMessage("查询数据成功");
            jsonView.setData(pageInfo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setTodoCount(pageInfo.getSize());
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 修改代理权限
     * @param agentMerchant 可选参数
     *                      id
     *                      gentuserid
     *                      merchantid
     *                      productinfoid
     *                      agenttime
     *                      updatetime
     *                      status
     * @return
     */
    @RequestMapping(value = "/updateAgentMerchant",method = RequestMethod.POST)
    public JsonView updateAgentMerchant(AgentMerchant agentMerchant){
        JsonView jsonView = new JsonView();
        try {
            int i = agentMerchantService.updateAgentMerchant(agentMerchant);
            jsonView.setMessage("修改数据成功");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setTodoCount(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

}
