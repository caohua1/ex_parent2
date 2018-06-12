package com.ex.dao;

import com.ex.entity.ProductClassify;

import java.util.List;

public interface ProductClassifyDao {

    public List<ProductClassify> selectProductClassify(ProductClassify productClassify);
}
