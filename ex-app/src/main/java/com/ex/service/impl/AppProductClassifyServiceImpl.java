package com.ex.service.impl;

import com.ex.dao.ProductClassifyDao;
import com.ex.dao.ProductInfoManageDao;
import com.ex.dao.ProductPropertySetDao;
import com.ex.entity.ProductClassify;
import com.ex.entity.ProductPropertySet;
import com.ex.service.AppProductClassifyService;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class AppProductClassifyServiceImpl implements AppProductClassifyService {

    @Autowired
    private ProductClassifyDao productClassifyDao;
    @Autowired
    private ProductInfoManageDao productInfoManageDao;
    @Autowired
    private ProductPropertySetDao productPropertySetDao;

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
     * 查询总数
     * @param productClassify
     * @return
     */
    @Override
    public Integer selectProductClassifyCount(ProductClassify productClassify) {
        return productClassifyDao.selectProductClassifyCount(productClassify);
    }

    /**
     * 根据二级分类，查询商品
     * @param parentId
     * @return
     */
    @Override
    public PageInfo<ProductInfoManageVo> selectCoreProductInfos(Map map, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<ProductInfoManageVo> productInfoManageVos = productInfoManageDao.selectCoreProductInfos(map);
        if(productInfoManageVos!=null && productInfoManageVos.size()>0){
            for(ProductInfoManageVo productInfoManage1 : productInfoManageVos){
                List<ProductPropertySet> productPropertySets = productPropertySetDao.selectPropertySet(productInfoManage1.getId());
                //把商品规格set进去
                productInfoManage1.setProductPropertySetList(productPropertySets);
            }
        }
        PageInfo<ProductInfoManageVo> pageInfo = new PageInfo<>(productInfoManageVos);
        return pageInfo;
    }
}
