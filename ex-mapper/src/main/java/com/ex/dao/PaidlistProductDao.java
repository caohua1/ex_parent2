package com.ex.dao;

import java.util.Map;

public interface PaidlistProductDao {

    public int insertPaidlistProduct(Map conditionMap);

    public int updateState(String outTradeNo);


}
