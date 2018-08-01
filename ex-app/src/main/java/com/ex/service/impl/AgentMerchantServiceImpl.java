package com.ex.service.impl;

import com.ex.dao.AgentMerchantDao;
import com.ex.entity.AgentMerchant;
import com.ex.service.AgentMerchantService;
import com.ex.vo.AgentMerchantProductinfoVo;
import com.ex.vo.AgentMerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AgentMerchantServiceImpl implements AgentMerchantService {

    @Autowired
    private AgentMerchantDao agentMerchantDao;

    /**
     * 按条件查询可代理商品的商家信息
     * @param agentUserId
     * @return
     */
    @Override
    public List<AgentMerchantVo> byConditionsQueryAndMerchantInfo(Long agentUserId) {
        return agentMerchantDao.byConditionsQueryAndMerchantInfo(agentUserId);
    }

    /**
     * 按条件查询可代理商品的详细信息
     * @param agentUserId
     * @return
     */
    @Override
    public List<AgentMerchantProductinfoVo> byConditionsQueryAndProductinfo(Long agentUserId) {
        return agentMerchantDao.byConditionsQueryAndProductinfo(agentUserId);
    }

    /**
     * 按ID和用户ID修改商家代理
     * @param agentMerchant
     * @return
     */
    @Override
    public int updateAgentMerchantByAgentUserId(AgentMerchant agentMerchant) {
        if (agentMerchant.getStatus()>=2)//阻断越级代理商品 如果越级代理商品自动变成申请代理状态
            agentMerchant.setStatus(1);
        agentMerchant.setUpdatetime(new Date());
        return agentMerchantDao.updateAgentMerchantByAgentUserId(agentMerchant);
    }
}
