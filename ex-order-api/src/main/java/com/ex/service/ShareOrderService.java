package com.ex.service;

import com.ex.entity.ShareOrder;
import com.ex.entity.ShareOrderInfo;
import com.ex.util.PageRequest;
import com.ex.vo.OrderVo;
import com.ex.vo.ShareOrderInfoVo;
import com.ex.vo.ShareOrderVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 分享管理
 */
public interface ShareOrderService {
    List<ShareOrder> selectShareOrderAll(ShareOrder shareOrder, PageRequest pageRequest);
    List<ShareOrderVo> selectShareOrderByShareUserIdAll(Long shareUserId,Long productInfoId);
    ShareOrder selectShareOrderById(Long id);
    int insertShareOrder(ShareOrder shareOrder);
    int uodateShareOrder(ShareOrder shareOrder);
    ShareOrderInfo selectShareOrderInfo(Map<String,Object> map);
    ShareOrderInfoVo selectShareOrederInfoVo(Long userId);
    //=================================后台订单管理，分享订单
    public PageInfo<ShareOrderInfoVo> selectAllShareOrderByParam(ShareOrderInfoVo shareOrderInfoVo,PageRequest pageRequest);


}
