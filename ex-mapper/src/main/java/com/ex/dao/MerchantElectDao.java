package com.ex.dao;

import com.ex.entity.StoreInfo;
import com.ex.vo.MerchantCoreVo;
import com.ex.vo.MerchantElectVo;

import java.util.List;
import java.util.Map;

public interface MerchantElectDao {

    public int insertMerchantElect(Map  termMap);

    public List<MerchantElectVo> selectUnconfirmed(Long BeMerchantId);

    public List<MerchantElectVo> selectElectManage(Long merchantId);

    public int updateMerchantElect(Map termMap);

    public List<MerchantCoreVo> selectAllMerchant();

    public List<StoreInfo> selectMerchantElect(Long merchantId);

}
