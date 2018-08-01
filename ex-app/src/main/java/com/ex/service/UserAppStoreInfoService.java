package com.ex.service;

import com.ex.vo.UserAppAgentStoreInfoVo;

public interface UserAppStoreInfoService {
    //按商家ID查询用户APP可代理店铺的详细信息
    UserAppAgentStoreInfoVo selectUserAppAgentStoreInfo(Long merchantId);
}
