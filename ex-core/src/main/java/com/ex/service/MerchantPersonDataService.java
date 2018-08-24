package com.ex.service;
import com.ex.entity.MerchantTransaction;
import com.ex.util.PageRequest;
import com.ex.vo.MerchantMoneyVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface MerchantPersonDataService {
    //======================后台查询商家的资金账户明细
    //可用余额，用户id
    public PageInfo<MerchantMoneyVo> selectMerchantYuE(Map map, PageRequest pageRequest);
    //交易明细
    public PageInfo<MerchantTransaction> selectMerchantTransaction(Map map,PageRequest pageRequest);
}
