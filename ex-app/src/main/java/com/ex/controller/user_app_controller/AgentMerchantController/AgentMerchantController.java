package com.ex.controller.user_app_controller.AgentMerchantController;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/AgentMerchant")
public class AgentMerchantController {

    @Autowired
    private AgentMerchantService agentMerchantService;

    /**
     * 按条件查询商家代理并返回商家信息 如果只有用户Id查所有 店铺名称实现模糊查询
     *
     * @param agentUserId       用户ID
     * @param storeName         店铺名称
     * @param productClassifyId 主营类目ID
     * @param pageRequest       分页信息
     * @return
     */
    @RequestMapping("/byConditionsQueryAndMerchantInfo")
    public JsonView byConditionsQuery(Long agentUserId, String storeName, Long productClassifyId, PageRequest pageRequest) {
        JsonView jsonView = new JsonView();
        try {
            List<AgentMerchantVo> agentMerchantVos = agentMerchantService.byConditionsQueryAndMerchantInfo(agentUserId, storeName, productClassifyId);
            PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
            PageInfo<AgentMerchantVo> pageInfo = new PageInfo<>(agentMerchantVos);
            jsonView.setTodoCount(agentMerchantVos.size());
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求成功!");
            jsonView.setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }


    /**
     * 按条件查询可代理商品的详细信息
     * @param agentUserId 用户ID
     * @param merchanId 商家ID
     * @param status 状态(0用户可代理此商品 1申请代理 2成功成为代理 3代理失败 4取消代理) 默认是0
     * @param pageRequest 分页信息
     * @return
     */
    @RequestMapping("/byConditionsQueryAndProductinfo")
    public JsonView byConditionsQueryAndProductinfo(Long agentUserId, Long merchanId, Integer status, PageRequest pageRequest) {
        JsonView jsonView = new JsonView();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            if (agentUserId != null)
                map.put("agentUserId", agentUserId);
            if (merchanId != null)
                map.put("merchanId", merchanId);
            if (status != null) {
                map.put("status", status);
            } else {
                map.put("status", 0);
            }
            List<AgentMerchantProductinfoVo> agentMerchantProductinfoVos = agentMerchantService.byConditionsQueryAndProductinfo(map);
            PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
            PageInfo<AgentMerchantProductinfoVo> pageInfo = new PageInfo<>(agentMerchantProductinfoVos);
            jsonView.setTodoCount(agentMerchantProductinfoVos.size());
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求成功!");
            jsonView.setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }


}
