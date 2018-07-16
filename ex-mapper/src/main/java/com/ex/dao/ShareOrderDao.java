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

    //按条件查询所有分享信息
    List<ShareOrder> selectShareOrderAll(ShareOrder shareOrder);
    //按分享人id查询所有分享信息
    List<ShareOrder> selectShareOrderByShareUserIdAll(@Param("shareUserId") long shareUserId);
    //按条件id精确查找分享信息
    ShareOrder selectShareOrderById(@Param("id") long id);
    //添加分享信息
    int insertShareOrder(ShareOrder shareOrder);
    //修改分享信息
    int uodateShareOrder(ShareOrder shareOrder);
    //
    ShareOrderInfo selectShareOrderInfo(@Param("merchantId") long merchantId,@Param("payStatus") int payStatus);
    //
    ProductInfoManage selectproductinfoById(@Param("productinfoid")long productinfoid);
}
