package com.ex.dao;

import com.ex.entity.ProductInfoManage;
import com.ex.entity.ShareOrder;
import com.ex.entity.ShareOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分享管理
 */
@Mapper
public interface ShareOrderDao {

    List<ShareOrder> selectShareOrderAll(ShareOrder shareOrder);
    ShareOrder selectShareOrderById(Long id);
    int insertShareOrder(ShareOrder shareOrder);
    int uodateShareOrder(ShareOrder shareOrder);
    ShareOrderInfo selectShareOrderInfo(@Param("merchantId") long merchantId,@Param("payStatus") int payStatus);
    ProductInfoManage selectproductinfoById(@Param("productinfoid")long productinfoid);
}
