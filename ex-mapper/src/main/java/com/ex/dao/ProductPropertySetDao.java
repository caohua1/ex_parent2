package com.ex.dao;

import com.ex.entity.ProductPropertySet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductPropertySetDao {

    public Integer insertPropertySet(List<ProductPropertySet> list);

    public List<ProductPropertySet> selectPropertySet(Long productinfoId);

    public Integer updatePropertySet(ProductPropertySet productPropertySet);

    //根据订单查询购买的规格
    public List<ProductPropertySet> selectSetByOrder(List ids);
}
