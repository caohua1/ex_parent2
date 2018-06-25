package com.ex.service.impl;

import com.ex.dao.ProductClassifyDao;
import com.ex.entity.ProductClassify;
import com.ex.service.ProductClassifyService;
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
public class ProductClassifyServiceImpl implements ProductClassifyService {

    @Autowired
    private ProductClassifyDao productClassifyDao;

    /**
     * 分页查询商品分类
     * @param productClassify
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<ProductClassify> selectProductClassify(ProductClassify productClassify, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<ProductClassify> productClassifies = productClassifyDao.selectProductClassify(productClassify);
        PageInfo<ProductClassify> pageInfo = new PageInfo<>(productClassifies);
        return pageInfo;
    }

    /**
     * 添加商品分类
     * @param productClassify
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer insertProductClassify(ProductClassify productClassify) {
        return productClassifyDao.insertProductClassify(productClassify);
    }

    /**
     * 修改商品分类
     * @param productClassify
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer updateProductClassify(ProductClassify productClassify) {
        return productClassifyDao.updateProductClassify(productClassify);
    }

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer deleteProductClassify(Long id) {
        return productClassifyDao.deleteProductClassify(id);
    }

    /**
     * 查询总数
     * @param productClassify
     * @return
     */
    @Override
    public Integer selectProductClassifyCount(ProductClassify productClassify) {
        return productClassifyDao.selectProductClassifyCount(productClassify);
    }
}
