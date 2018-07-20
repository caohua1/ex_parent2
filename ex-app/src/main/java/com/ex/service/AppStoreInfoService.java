package com.ex.service;
import com.ex.entity.StoreInfo;
import com.ex.util.PageRequest;
import com.ex.vo.StoreInfoVo;
import com.github.pagehelper.PageInfo;
import java.util.Map;

public interface AppStoreInfoService {


    PageInfo<StoreInfo> byConditionsQuery(PageRequest page, StoreInfo storeInfo);
    //通过二级商品分类，查询所有的商家列表
    public PageInfo<StoreInfoVo> selectStoreInfosByProductClassifyId2(Long productClassifyId, PageRequest pageRequest);

    //商家列表页/搜索结果页，搜索功能（商家名称，地理位置，分类，销量最高，综合评价,productClassifyId=5）
    public PageInfo<StoreInfoVo> selectMerchantsByParam(Map map,PageRequest pageRequest);

}
