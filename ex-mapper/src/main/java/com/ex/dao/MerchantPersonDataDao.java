package com.ex.dao;

import com.ex.entity.MerchantTransaction;
import com.ex.entity.UserTransaction;
import com.ex.vo.MerchantMoneyVo;
import com.ex.vo.MerchantPersonDataVo;
import com.ex.vo.UserMoneyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MerchantPersonDataDao {

    //添加商家的个人资料
    public Integer insertMerchantPersonData(MerchantPersonDataDao merchantPersonDataDao);

    //根据商家id查询此商家的个人资料
    public MerchantPersonDataVo selectPersonDataByMerchantId(Long merchantId);

    //======================后台查询商家的资金账户明细
    //可用余额，用户id
    public List<MerchantMoneyVo> selectMerchantYuE(Map map);
    //提取中的金额
    public Double selectTQMoney(Long merchantId);
    //交易明细
    public List<MerchantTransaction> selectMerchantTransaction(Map map);
}
