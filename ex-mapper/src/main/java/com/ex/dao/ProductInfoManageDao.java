package com.ex.dao;

import com.ex.entity.ProductInfoManage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductInfoManageDao {

    public Integer insertProductInfo(ProductInfoManage productInfoManage);

    public Integer shareSet(ProductInfoManage productInfoManage);
}
