package com.ex.dao;

import com.ex.entity.MerchantTransaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MerchantTransactionDao {

    //商家交易
    public Integer insertMerchantTransaction(MerchantTransaction merchantTransaction);

    //查询商家某项交易的金额
    public Double selectJYMoney(Map map);
}
