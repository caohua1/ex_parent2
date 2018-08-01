package com.ex.controller.user_app_controller.AgentMerchantController;

import com.ex.entity.AgentMerchant;
import com.ex.service.AgentMerchantService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.AgentMerchantProductinfoVo;
import com.ex.vo.AgentMerchantVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/AgentMerchant")
public class AgentMerchantController {

    @Autowired
    private AgentMerchantService agentMerchantService;

    /**
     * 按条件查询商家代理并返回商品信息
     * @param agentUserId
     * @param pageRequest
     * @return
     */
    @RequestMapping("byConditionsQueryAndMerchantInfo")
    public JsonView byConditionsQuery(Long agentUserId, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try {
            List<AgentMerchantVo> agentMerchantVos = agentMerchantService.byConditionsQueryAndMerchantInfo(agentUserId);
            PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
            PageInfo<AgentMerchantVo> pageInfo = new PageInfo<>(agentMerchantVos);
            jsonView.setTodoCount(agentMerchantVos.size());
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求成功!");
            jsonView.setData(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }



    /**
     * 按条件查询可代理商品的详细信息
     * @param agentUserId
     * @param pageRequest
     * @return
     */
    @RequestMapping("byConditionsQueryAndProductinfo")
    public JsonView byConditionsQueryAndProductinfo(Long agentUserId, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try {
            List<AgentMerchantProductinfoVo> agentMerchantProductinfoVos = agentMerchantService.byConditionsQueryAndProductinfo(agentUserId);
            PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
            PageInfo<AgentMerchantProductinfoVo> pageInfo = new PageInfo<>(agentMerchantProductinfoVos);
            jsonView.setTodoCount(agentMerchantProductinfoVos.size());
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求成功!");
            jsonView.setData(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }


}
