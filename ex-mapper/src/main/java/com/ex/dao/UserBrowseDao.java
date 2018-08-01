package com.ex.dao;

import com.ex.entity.UserBrowse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBrowseDao {

    //用户浏览商家商品（店铺记录）
    public Integer insertUserBrowse(UserBrowse userBrowse);

    //此商家的用户今日浏览量
    public Integer selectBrowsesByMerchantId(Long merchantId);
}
