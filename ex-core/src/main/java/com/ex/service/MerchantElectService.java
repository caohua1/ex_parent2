package com.ex.service;

import com.ex.util.PageRequest;
import com.ex.vo.MerchantCoreVo;
import com.ex.vo.MerchantElectVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface MerchantElectService {

    public int insertMerchantElect(Map termMap);

    public PageInfo<MerchantElectVo> selectUnconfirmed(PageRequest page, Long BeMerchantId);

    public PageInfo<MerchantElectVo> selectElectManage(PageRequest page,Long merchantId);

    public int updateMerchantElect(Map termMap);

    public PageInfo<MerchantCoreVo> selectAllMerchant(PageRequest page);
}
