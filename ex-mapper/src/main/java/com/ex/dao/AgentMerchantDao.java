package com.ex.dao;

import com.ex.entity.AgentMerchant;
import com.ex.vo.AgentMerchantProductinfoVo;
import com.ex.vo.AgentMerchantVo;
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
     * 按条件查询可代理商品的商家信息
     * @param agentUserId
     * @return
     */
    List<AgentMerchantVo> byConditionsQueryAndMerchantInfo(Long agentUserId);

    /**
     * 按条件查询可代理商品的详细信息
     * @param agentUserId
     * @return
     */
    List<AgentMerchantProductinfoVo> byConditionsQueryAndProductinfo(Long agentUserId);

    /**
     * 按条件修改商家代理
     * @param agentMerchant
     * @return
     */
    int updateAgentMerchant(AgentMerchant agentMerchant);

    /**
     * 按ID和用户ID修改商家代理
     * @param agentMerchant
     * @return
     */
    int updateAgentMerchantByAgentUserId(AgentMerchant agentMerchant);
}
