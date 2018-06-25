package com.ex.service;

import com.ex.entity.MerchantInviter;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MerchantInviterService {

    int insertMerchantInviter(MerchantInviter merchantInviter);

    PageInfo<MerchantInviter> byConditionsQuery(PageRequest page,  MerchantInviter merchantInviter);

    MerchantInviter selectInvitercode(Long invitermerchantid);

    MerchantInviter selectInvitercodeByInvitercode(Long invitercode);
    /**
     * 修改邀请码状态
     * @param merchantInviter
     * @return
     */
    int updateInvitercode(MerchantInviter merchantInviter);
}
