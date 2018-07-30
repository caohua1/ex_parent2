package com.ex.dao;

import com.ex.entity.MyCollect;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyCollectDao {

    //添加我的收藏
    public Integer insertMyCollect(MyCollect myCollect);
}
