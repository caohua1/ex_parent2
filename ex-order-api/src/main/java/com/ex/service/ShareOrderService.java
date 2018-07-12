package com.ex.service;

import com.ex.entity.ProductInfoManage;
import com.ex.entity.ShareOrder;
import com.ex.entity.ShareOrderInfo;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 分享管理
 */
public interface ShareOrderService {
    List<ShareOrder> selectShareOrderAll(ShareOrder shareOrder, PageRequest pageRequest);
    ShareOrder selectShareOrderById(Long id);
    int insertShareOrder(ShareOrder shareOrder);
    int uodateShareOrder(ShareOrder shareOrder);
    ShareOrderInfo selectShareOrderInfo(Map<String,Object> map);
    ProductInfoManage selectproductinfoById(Long productinfoid);
}
