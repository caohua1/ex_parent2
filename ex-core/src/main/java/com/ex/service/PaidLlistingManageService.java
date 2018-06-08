package com.ex.service;

import com.ex.dao.PaidLlistingManageDao;
import com.ex.entity.PaidLlistingManage;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;


import java.util.Map;

public interface PaidLlistingManageService {

    public PageInfo<PaidLlistingManage> selectPaidLlisting(PageRequest page, Map conditionMap);

    public int delectPaidLlisting(Long id);
}
