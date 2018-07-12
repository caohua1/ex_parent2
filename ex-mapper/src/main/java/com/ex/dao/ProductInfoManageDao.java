package com.ex.dao;

import com.ex.entity.ProductInfoManage;
import com.ex.vo.ProductInfoManageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductInfoManageDao {

    public Integer insertProductInfo(ProductInfoManage productInfoManage);

    public Integer updateProductInfo(ProductInfoManage productInfoManage);

    public List<ProductInfoManageVo> selectProductInfos(ProductInfoManageVo productInfoManageVo);

    public Integer selectCount(ProductInfoManageVo productInfoManageVo);

    public ProductInfoManageVo selectProductInfoById(Long id);

    //后台运营，分页查询所有的商品

    public List<ProductInfoManageVo> selectCoreProductInfos(Map map);

    public Integer selectCoreProductInfosCount(Map map);

    //根据merchantId查询某商家的所有的商品
    public List<ProductInfoManageVo> selectProductsByMerchantId(Long merchantId);
}
