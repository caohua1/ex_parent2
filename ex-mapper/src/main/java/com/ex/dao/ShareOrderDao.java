package com.ex.dao;

import com.ex.entity.ShareOrder;
import com.ex.entity.ShareOrderInfo;
import com.ex.vo.OrderVo;
import com.ex.vo.ShareOrderInfoPCVo;
import com.ex.vo.ShareOrderInfoVo;
import com.ex.vo.ShareOrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 分享管理
 */
@Mapper
public interface ShareOrderDao {

    //按条件查询所有分享信息
    List<ShareOrder> selectShareOrderAll(ShareOrder shareOrder);
    //按分享人id查询所有分享信息
    List<ShareOrderVo> selectShareOrderByShareUserIdAll(@Param("shareUserId") Long shareUserId,@Param("productInfoId") Long productInfoId);
    //按条件id精确查找分享信息
    ShareOrder selectShareOrderById(@Param("id") Long id);
    //添加分享信息
    int insertShareOrder(ShareOrder shareOrder);
    //修改分享信息
    int uodateShareOrder(ShareOrder shareOrder);
    //查询顶部统计数据----PC
    ShareOrderInfoPCVo selectShareOrderInfo(@Param("merchantId") Long merchantId, @Param("payStatus") Integer payStatus);
    //查询顶部统计数据----UserAPP
    ShareOrderInfoVo selectShareOrederInfoVo(@Param("userId")Long userId, @Param("finishTime")Date date);

    //=================================后台订单管理，分享订单
    public List<ShareOrderInfoVo> selectAllShareOrderByParam(ShareOrderInfoVo shareOrderInfoVo);


}
