package com.ex.service.impl;

import com.ex.dao.ProductClassifyDao;
import com.ex.dao.ProductInfoManageDao;
import com.ex.dao.ProductPropertySetDao;
import com.ex.entity.ProductClassify;
import com.ex.entity.ProductInfoManage;
import com.ex.entity.ProductPropertySet;
import com.ex.service.ProductService;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductClassifyDao productClassifyDao;
    @Autowired
    private ProductInfoManageDao productInfoManageDao;
    @Autowired
    private ProductPropertySetDao productPropertySetDao;

    /**
     * 选择商品分类（根据级别（一级/二级/三级））
     * @param productClassify
     * @return
     */
    @Override
    public List<ProductClassify> selectProductClassify(ProductClassify productClassify) {
        List<ProductClassify> productClassifies = productClassifyDao.selectProductClassify(productClassify);
        if(productClassifies!=null && productClassifies.size()>0){
            //遍历一级菜单,查询子菜单
            for(ProductClassify productClassify1:productClassifies){
                ProductClassify productClassify2 = new ProductClassify();
                productClassify2.setParentId(productClassify1.getId());
                productClassify2.setLevelNum(2);
                List<ProductClassify> productClassifies1 = productClassifyDao.selectProductClassify(productClassify2);
                if(productClassifies1!=null && productClassifies1.size()>0){
                    //遍历二级菜单，查询子菜单
                    for(ProductClassify productClassify3:productClassifies1){
                        ProductClassify productClassify4 = new ProductClassify();
                        productClassify4.setParentId(productClassify3.getId());
                        productClassify4.setLevelNum(3);
                        List<ProductClassify> productClassifies2 = productClassifyDao.selectProductClassify(productClassify4);
                        //把三级菜单set到二级菜单
                        productClassify3.setProductClassifyList(productClassifies2);
                    }
                }
                //把二级菜单set到其一级菜单中
                productClassify1.setProductClassifyList(productClassifies1);
            }
        }
        return productClassifies;
    }


    /**
     * 添加商品信息（批量添加商品的规格）
     * @param productInfoManage
     * @param list
     * @return
     */
    //事物处理
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Boolean insertProduct(ProductInfoManage productInfoManage, List<ProductPropertySet> list) {
        Integer i = productInfoManageDao.insertProductInfo(productInfoManage);
        Integer j = productPropertySetDao.insertPropertySet(list);
        return i>0&&(j>0&&j==list.size());
    }


    /**
     * 修改商品详情（分享设置）
     * @param productInfoManage
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Boolean updateProductInfo(ProductInfoManage productInfoManage,List<ProductPropertySet> productPropertySetList) {
        Integer i = productInfoManageDao.updateProductInfo(productInfoManage);
        Integer j=0;
        if(productPropertySetList!=null && productPropertySetList.size()>0){
            for(ProductPropertySet productPropertySet : productPropertySetList){
                productPropertySet.setUpdateTime(new Date());
                j += productPropertySetDao.updatePropertySet(productPropertySet);
            }
            return (i>0)&&(j== productPropertySetList.size())&&j!=0;
        }else{
            return i>0;
        }

    }

    /**
     * 分页查询所有的商品（条件查询，）
     * @param productInfoManageVo
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<ProductInfoManageVo> selectProductInfos(ProductInfoManageVo productInfoManageVo, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<ProductInfoManageVo> productInfoManages = productInfoManageDao.selectProductInfos(productInfoManageVo);
        if(productInfoManages!=null && productInfoManages.size()>0){
            for(ProductInfoManageVo productInfoManage1 : productInfoManages){
                List<ProductPropertySet> productPropertySets = productPropertySetDao.selectPropertySet(productInfoManage1.getId());
                //把商品规格set进去
                productInfoManage1.setProductPropertySetList(productPropertySets);
            }
        }
        PageInfo<ProductInfoManageVo> pageInfo = new PageInfo<>(productInfoManages);
        return pageInfo;
    }

    /**
     * 查询总数量
     * @param productInfoManageVo
     * @return
     */
    @Override
    public Integer selectCount(ProductInfoManageVo productInfoManageVo) {
        return productInfoManageDao.selectCount(productInfoManageVo);
    }

    /**
     * 查询商品的详情
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
     *  后台运营，分页查询所有的商品
     * @param map
     * @param pageRequest
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

    /**
     * 查询总数量
     * @param map
     * @return
     */
    @Override
    public Integer selectCoreProductInfosCount(Map map) {
        return productInfoManageDao.selectCoreProductInfosCount(map);
    }

    //=============================商家app查询所有商品信息
    @Override
    public PageInfo<ProductInfoManageVo> selectAppProductInfos(ProductInfoManageVo productInfoManageVo,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<ProductInfoManageVo> productInfoManageVos = productInfoManageDao.selectProductInfos(productInfoManageVo);
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
