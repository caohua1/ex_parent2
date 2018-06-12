package com.ex.service.impl;

import com.ex.dao.ProductClassifyDao;
import com.ex.dao.ProductInfoManageDao;
import com.ex.dao.ProductPropertySetDao;
import com.ex.entity.ProductClassify;
import com.ex.entity.ProductInfoManage;
import com.ex.entity.ProductPropertySet;
import com.ex.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
     * 分享设置
     * @param productInfoManage
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer shareSet(ProductInfoManage productInfoManage) {
        return productInfoManageDao.shareSet(productInfoManage);
    }


}
