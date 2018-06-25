package com.ex.service;

import com.ex.entity.ProductClassify;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;


public interface ProductClassifyService {
    public PageInfo<ProductClassify> selectProductClassify(ProductClassify productClassify, PageRequest pageRequest);
    public Integer insertProductClassify(ProductClassify productClassify);
    public Integer updateProductClassify(ProductClassify productClassify);
    public Integer deleteProductClassify(Long id);
    public Integer selectProductClassifyCount(ProductClassify productClassify);
}
