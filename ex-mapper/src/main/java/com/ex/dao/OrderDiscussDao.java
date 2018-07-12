package com.ex.dao;

import com.ex.vo.OrderDiscussVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDiscussDao {

    public List<OrderDiscussVo> selectDiscussByMerchantIdAndProductInfoId(Map map);
}
