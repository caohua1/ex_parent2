package com.ex.service;

import java.util.Map;

public interface PaidlistProductService {

    public int insertPaidlistProduct(Map conditionMap);

    public int updateState(String outTradeNo);
}
