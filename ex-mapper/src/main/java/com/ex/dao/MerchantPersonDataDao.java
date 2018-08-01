package com.ex.dao;

import com.ex.vo.MerchantPersonDataVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MerchantPersonDataDao {

    //添加商家的个人资料
    public Integer insertMerchantPersonData(MerchantPersonDataDao merchantPersonDataDao);

    //根据商家id查询此商家的个人资料
    public MerchantPersonDataVo selectPersonDataByMerchantId(Long merchantId);
}
