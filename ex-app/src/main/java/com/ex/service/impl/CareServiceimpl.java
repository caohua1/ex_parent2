package com.ex.service.impl;

import com.ex.dao.CareDao;
import com.ex.service.CareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class CareServiceimpl implements CareService {

    @Autowired
    private CareDao careDao;

    /**
     * 添加关注数据
     * @param demandMap
     * @return
     */
    @Override
    public int insertCare(Map demandMap) {
        return careDao.insertCare(demandMap);
    }

    /**
     * 用户取消关注状态
     * @param demandMap
     * @return
     */
    @Override
    public int updateCare(Map demandMap) {
        return careDao.updateCare(demandMap);
    }
}
