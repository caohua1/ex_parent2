package com.ex.service;

import com.ex.entity.ProductClassify;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;


public interface AppProductClassifyService {
    public PageInfo<ProductClassify> selectProductClassify(ProductClassify productClassify, PageRequest pageRequest);
    public Integer selectProductClassifyCount(ProductClassify productClassify);
    //根据二级分类查询商品
    public PageInfo<ProductInfoManageVo> selectCoreProductInfos(Map map,PageRequest pageRequest);
}
