package com.ex.service;

import com.ex.entity.AgentMerchant;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AgentMerchantService {
    /**
     * 添加商家代理
     * @param agentMerchant
     * @return
     */
    int insertAgentMerchant(AgentMerchant agentMerchant);

    /**
     * 按条件查询商家代理
     * @param agentMerchant
     * @return
     */
    PageInfo<AgentMerchant> byConditionsQuery(PageRequest page, AgentMerchant agentMerchant);

    /**
     * 按条件修改商家代理
     * @param agentMerchant
     * @return
     */
    int updateAgentMerchant(AgentMerchant agentMerchant);
}
