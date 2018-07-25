package com.ex.service.impl;

import com.ex.dao.IndexAdvertisingDao;
import com.ex.dao.ProductClassifyDao;
import com.ex.dao.ProductInfoManageDao;
import com.ex.dao.StoreInfoDao;
import com.ex.entity.IndexAdvertising;
import com.ex.entity.ProductClassify;
import com.ex.entity.StoreInfo;
import com.ex.service.ExIndexService;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.ex.vo.StoreInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExIndexServiceImpl implements ExIndexService {

    @Autowired
    private StoreInfoDao storeInfoDao;
    @Autowired
    private ProductClassifyDao productClassifyDao;
    @Autowired
    private ProductInfoManageDao productInfoManageDao;
    @Autowired
    private IndexAdvertisingDao indexAdvertisingDao;

    /**
     * 用户app端，二享模块，查询所有的一级商品分类
     * @param productClassify
     * @return
     */
    @Override
    public PageInfo<ProductClassify> selectProductClassify(ProductClassify productClassify,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<ProductClassify> productClassifies = productClassifyDao.selectProductClassify(productClassify);
        PageInfo<ProductClassify> pageInfo = new PageInfo<>(productClassifies);
        return pageInfo;
    }

    /**
     * 通过一级商品分类查询所有的商家列表
     * @param productClassifyId
     * @return
     */
    @Override
    public PageInfo<StoreInfoVo> selectStoreInfosByProductClassifyId1(Long productClassifyId,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<StoreInfoVo> storeInfos = storeInfoDao.selectStoreInfosByProductClassifyId1(productClassifyId);
        PageInfo<StoreInfoVo> pageInfo = new PageInfo<>(storeInfos);
        return pageInfo;
    }

    /**
     * 查询推荐商品
     * @param productInfoManageVo
     * @return
     */
    @Override
    public PageInfo<ProductInfoManageVo> selectProductInfos(ProductInfoManageVo productInfoManageVo,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<ProductInfoManageVo> productInfoManageVos = productInfoManageDao.selectProductInfos(productInfoManageVo);
        PageInfo<ProductInfoManageVo> pageInfo = new PageInfo<>(productInfoManageVos);
        return pageInfo;
    }

    /**
     * 查询推荐商家
     * @param storeInfo
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<StoreInfo> byConditionsQuery(StoreInfo storeInfo, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<StoreInfo> storeInfos = storeInfoDao.byConditionsQuery(storeInfo);
        PageInfo<StoreInfo> pageInfo = new PageInfo<>(storeInfos);
        return pageInfo;
    }

    /**
     * 模糊查询，根据商家店铺名称，查询进入商家列表页
     * @param storeName
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<StoreInfoVo> selectStoreByStoreName(String storeName, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<StoreInfoVo> storeInfoVos = storeInfoDao.selectStoreByStoreName(storeName);
        PageInfo<StoreInfoVo> pageInfo = new PageInfo<>(storeInfoVos);
        return pageInfo;
    }

    /**
     * 首页广告
     * @return
     */
    @Override
    public List<IndexAdvertising> selectAdvertising(Map map) {
        return indexAdvertisingDao.selectAdvertising(map);
    }
}
