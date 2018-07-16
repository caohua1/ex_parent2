package com.ex.dao;


import com.ex.entity.StoreInfo;
import com.ex.vo.StoreInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface StoreInfoDao {

    int insertStoreInfo(StoreInfo storeInfo);

    List<StoreInfo> byConditionsQuery(@Param("record") StoreInfo storeInfo);

    int updateStoreInfo(StoreInfo storeInfo);


    //通过一级商品分类查询所有的商家列表
    public List<StoreInfoVo> selectStoreInfosByProductClassifyId1(Long productClassifyId);
   //通过二级商品分类，查询所有的商家列表
   public List<StoreInfoVo>  selectStoreInfosByProductClassifyId2(Long productClassifyId);




}
