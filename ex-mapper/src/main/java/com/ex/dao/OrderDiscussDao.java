package com.ex.dao;

import com.ex.entity.OrderDiscuss;
import com.ex.vo.OrderDiscussVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDiscussDao {

    public List<OrderDiscussVo> selectDiscussByMerchantIdAndProductInfoId(Map map);

    //计算商家的平均评分，（所有订单的评论）
    public Double selectMerchantDiscussAvg(Long merchantId);

    int insertOrderDiscuss(OrderDiscuss orderDiscuss);
}
