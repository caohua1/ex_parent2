package com.ex.service;

import com.ex.entity.ShareOrder;
import com.ex.vo.ShareOrderInfoPCVo;
import com.ex.util.PageRequest;
import com.ex.vo.ShareOrderInfoVo;
import com.ex.vo.ShareOrderVo;

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
    ShareOrderInfoPCVo selectShareOrderInfo(Map<String,Object> map);
    ShareOrderInfoVo selectShareOrederInfoVo(Long userId);
}
