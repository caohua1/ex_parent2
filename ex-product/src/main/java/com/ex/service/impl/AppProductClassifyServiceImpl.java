package com.ex.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.ProductClassifyDao;
import com.ex.dao.ProductInfoManageDao;
import com.ex.dao.ProductPropertySetDao;
import com.ex.dao.StoreInfoDao;
import com.ex.entity.ProductClassify;
import com.ex.entity.ProductPropertySet;
import com.ex.entity.StoreInfo;
import com.ex.service.AppProductClassifyService;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;


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
    private StoreInfoDao storeInfoDao;
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
    public PageInfo<StoreInfo> byConditionsQuery(PageRequest pageRequest, StoreInfo storeInfo) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<StoreInfo> storeInfos = storeInfoDao.byConditionsQuery(storeInfo);
        PageInfo<StoreInfo> pageInfo = new PageInfo<>(storeInfos);
        return pageInfo;
    }

    /**
     * 根据merchantId查询此商家的所有商品
     * @param merchantId
     * @return
     */
    @Override
    public PageInfo<ProductInfoManageVo> selectProductsByMerchantId(Map map,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<ProductInfoManageVo> productInfoManageVos = productInfoManageDao.selectProductsByMerchantId(map);
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


    @Override
    public List<ProductInfoManageVo> selectProductsByMerchantId2(Map map) {
        List<ProductInfoManageVo> productInfoManageVos = productInfoManageDao.selectProductsByMerchantId(map);
        if(productInfoManageVos!=null && productInfoManageVos.size()>0){
            for(ProductInfoManageVo productInfoManage1 : productInfoManageVos){
                List<ProductPropertySet> productPropertySets = productPropertySetDao.selectPropertySet(productInfoManage1.getId());
                //把商品规格set进去
                productInfoManage1.setProductPropertySetList(productPropertySets);
            }
        }
        return productInfoManageVos;
    }

    /**
     * 查询商品详情
     * @param id
     * @return
     */
    @Override
    public ProductInfoManageVo selectProductInfoById(Long id) {
        ProductInfoManageVo productInfoManageVo = productInfoManageDao.selectProductInfoById(id);
        if(productInfoManageVo!=null){
            List<ProductPropertySet> productPropertySets = productPropertySetDao.selectPropertySet(productInfoManageVo.getId());
            //规格
            productInfoManageVo.setProductPropertySetList(productPropertySets);
        }
        return productInfoManageVo;
    }

    /**
     * 根据店铺id查询此店铺的商品类别，（三级分类）
     * @param storeId
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<ProductClassify> selectProductClassifyByStoreId(Long storeId, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<ProductClassify> productClassifies = productClassifyDao.selectProductClassifyByStoreId(storeId);
        PageInfo<ProductClassify> pageInfo = new PageInfo<>(productClassifies);
        return pageInfo;
    }


}
