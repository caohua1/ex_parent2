package com.ex.dao;

import com.ex.entity.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandDao {

    public Integer insertBrand(Brand brand);
    public Integer updateBrand(Brand brand);
    public List<Brand> selectBrands(Brand brand);
    public Integer selectBrandsCount(Brand brand);
    public Integer deleteBrand(Long id);
}
