package com.ex.service;

import com.ex.entity.AgentMerchant;
import com.ex.util.PageRequest;
import com.ex.vo.AgentMerchantProductinfoVo;
import com.ex.vo.AgentMerchantVo;

import java.util.List;
import java.util.Map;


public interface AgentMerchantService {
    /**
     * 按条件查询可代理商品的商家信息
     * @param agentUserId
     * @return
     */
    List<AgentMerchantVo> byConditionsQueryAndMerchantInfo(Long agentUserId,String storeName,Long productClassifyId);

    /**
     * 按条件查询可代理商品的详细信息
     * @param map
     * @return
     */
    List<AgentMerchantProductinfoVo> byConditionsQueryAndProductinfo(Map map);

    /**
     * 按ID和用户ID修改商家代理
     * @param agentMerchant
     * @return
     */
    int updateAgentMerchantByAgentUserId(AgentMerchant agentMerchant);
}
