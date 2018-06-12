package com.ex.dao;

import com.ex.entity.ProductClassify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductClassifyDao {

    public List<ProductClassify> selectProductClassify(ProductClassify productClassify);
}
