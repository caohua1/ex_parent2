package com.ex.dao;

import com.ex.entity.AgentMerchant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AgentMerchantDao {

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
    List<AgentMerchant> byConditionsQuery(AgentMerchant agentMerchant);

    /**
     * 按条件修改商家代理
     * @param agentMerchant
     * @return
     */
    int updateAgentMerchant(AgentMerchant agentMerchant);
}
