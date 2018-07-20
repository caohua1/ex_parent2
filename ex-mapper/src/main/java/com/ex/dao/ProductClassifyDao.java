package com.ex.dao;

import com.ex.entity.ProductClassify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductClassifyDao {

    public List<ProductClassify> selectProductClassify(ProductClassify productClassify);
    public Integer insertProductClassify(ProductClassify productClassify);
    public Integer updateProductClassify(ProductClassify productClassify);
    public Integer deleteProductClassify(Long id);
    public Integer selectProductClassifyCount(ProductClassify productClassify);
    public List<ProductClassify> selectByLevelNum2(Long parentId);
    //根据店铺id查询此店铺的商品类别，（三级分类）
    public List<ProductClassify> selectProductClassifyByStoreId(Long storeId);
}
