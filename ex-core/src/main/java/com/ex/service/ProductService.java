package com.ex.service;

import com.ex.entity.ProductClassify;
import com.ex.entity.ProductInfoManage;
import com.ex.entity.ProductPropertySet;

import java.util.List;

public interface ProductService {
    public List<ProductClassify> selectProductClassify(ProductClassify productClassify);

    public Boolean insertProduct(ProductInfoManage productInfoManage, List<ProductPropertySet> list);

    public Integer shareSet(ProductInfoManage productInfoManage);

}
