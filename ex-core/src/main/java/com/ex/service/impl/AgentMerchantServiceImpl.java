package com.ex.service.impl;

import com.ex.dao.AgentMerchantDao;
import com.ex.entity.AgentMerchant;
import com.ex.service.AgentMerchantService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgentMerchantServiceImpl implements AgentMerchantService {

    @Autowired
    private AgentMerchantDao agentMerchantDao;

    /**
     * 添加商家代理
     * @param agentMerchant
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int insertAgentMerchant(AgentMerchant agentMerchant) {
        return agentMerchantDao.insertAgentMerchant(agentMerchant);
    }

    /**
     * 按条件查询商家代理
     * @param agentMerchant
     * @return
     */
    @Override
    public PageInfo<AgentMerchant> byConditionsQuery(PageRequest page, AgentMerchant agentMerchant) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AgentMerchant> list = agentMerchantDao.byConditionsQuery(agentMerchant);
        PageInfo<AgentMerchant> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 按条件修改商家代理
     * @param agentMerchant
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public int updateAgentMerchant(AgentMerchant agentMerchant) {
        return agentMerchantDao.updateAgentMerchant(agentMerchant);
    }
}
