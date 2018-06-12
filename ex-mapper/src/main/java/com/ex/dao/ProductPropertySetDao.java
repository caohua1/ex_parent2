package com.ex.dao;

import com.ex.entity.ProductPropertySet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductPropertySetDao {
    public Integer insertPropertySet(List<ProductPropertySet> list);
}
