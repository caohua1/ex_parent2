package com.ex.dao;


import com.ex.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreInfoDao {

    int insertStoreInfo(StoreInfo storeInfo);

    List<StoreInfo> byConditionsQuery(@Param("record") StoreInfo storeInfo);

    int updateStoreInfo(StoreInfo storeInfo);

}
