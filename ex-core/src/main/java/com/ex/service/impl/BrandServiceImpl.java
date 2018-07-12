package com.ex.service.impl;

import com.ex.dao.BrandDao;
import com.ex.entity.Brand;
import com.ex.service.BrandService;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    private BrandDao brandDao;

    /**
     * 添加品牌
     * @param brand
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer insertBrand(Brand brand) {
        return brandDao.insertBrand(brand);
    }

    /**
     * 修改品牌
     * @param brand
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer updateBrand(Brand brand) {
        return brandDao.updateBrand(brand);
    }

    /**
     * 分页查询品牌
     * @param brand
     * @return
     */
    @Override
    public PageInfo<Brand> selectBrands(Brand brand, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Brand> brands = brandDao.selectBrands(brand);
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        return pageInfo;
    }

    /**
     * 查询总数量
     * @param brand
     * @return
     */
    @Override
    public Integer selectBrandsCount(Brand brand) {
        return brandDao.selectBrandsCount(brand);
    }

    /**
     * 删除品牌
     * @param id
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer deleteBrand(Long id) {
        return brandDao.deleteBrand(id);
    }
}
