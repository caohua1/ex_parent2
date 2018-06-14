package com.ex.service;

import com.ex.entity.ProductClassify;
import com.ex.entity.ProductInfoManage;
import com.ex.entity.ProductPropertySet;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<ProductClassify> selectProductClassify(ProductClassify productClassify);

    public Boolean insertProduct(ProductInfoManage productInfoManage, List<ProductPropertySet> list);

    public Boolean updateProductInfo(ProductInfoManage productInfoManage,List<ProductPropertySet> productPropertySetList);

    public PageInfo<ProductInfoManageVo> selectProductInfos(ProductInfoManageVo productInfoManageVo, PageRequest pageRequest);

    public Integer selectCount(ProductInfoManageVo productInfoManageVo);

    public ProductInfoManageVo selectProductInfoById(Long id);

    //后台运营，分页查询所有的商品

    public PageInfo<ProductInfoManageVo> selectCoreProductInfos(Map map,PageRequest pageRequest);
    public Integer selectCoreProductInfosCount(Map map);

    //商家app，查询所有商品
    public List<ProductInfoManageVo> selectAppProductInfos(ProductInfoManageVo productInfoManageVo);
}
