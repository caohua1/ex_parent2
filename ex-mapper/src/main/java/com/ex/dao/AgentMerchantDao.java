package com.ex.dao;

import com.ex.entity.AgentMerchant;
import com.ex.vo.AgentMerchantProductinfoVo;
import com.ex.vo.AgentMerchantVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    List<AgentMerchantVo> byConditionsQueryAndMerchantInfo(@Param("agentUserId") Long agentUserId, @Param("storeName") String storeName, @Param("productClassifyId") Long productClassifyId);

    /**
     * 按条件查询可代理商品的详细信息
     * @param map
     * @return
     */
    List<AgentMerchantProductinfoVo> byConditionsQueryAndProductinfo(Map map);

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
