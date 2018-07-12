package com.ex.service;

import com.ex.entity.Brand;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;


public interface BrandService {
    public Integer insertBrand(Brand brand);
    public Integer updateBrand(Brand brand);
    public PageInfo<Brand> selectBrands(Brand brand, PageRequest pageRequest);
    public Integer selectBrandsCount(Brand brand);
    public Integer deleteBrand(Long id);
}
