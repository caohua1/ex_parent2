package com.ex.dao;


import com.ex.entity.StoreInfo;
import com.ex.vo.StoreInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface StoreInfoDao {

    int insertStoreInfo(StoreInfo storeInfo);

    List<StoreInfo> byConditionsQuery(@Param("record") StoreInfo storeInfo);

    int updateStoreInfo(StoreInfo storeInfo);


    //通过一级商品分类查询所有的商家列表
    public List<StoreInfoVo> selectStoreInfosByProductClassifyId1(Long productClassifyId);
   //通过二级商品分类，查询所有的商家列表
   public List<StoreInfoVo>  selectStoreInfosByProductClassifyId2(Long productClassifyId);

   //模糊查询，根据店铺名称
    public List<StoreInfoVo> selectStoreByStoreName(String storeName);

    //商家列表页/搜索结果页，搜索功能（商家名称，地理位置，分类，销量最高，综合评价,productClassifyId=5）
    public List<StoreInfoVo> selectMerchantsByParam(Map map);




}
