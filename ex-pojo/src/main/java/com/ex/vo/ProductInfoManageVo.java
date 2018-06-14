package com.ex.vo;

import com.ex.entity.ProductInfoManage;
import com.ex.entity.ProductPropertySet;

import java.util.List;

public class ProductInfoManageVo extends ProductInfoManage{
    List<ProductPropertySet> productPropertySetList;

    public List<ProductPropertySet> getProductPropertySetList() {
        return productPropertySetList;
    }

    public void setProductPropertySetList(List<ProductPropertySet> productPropertySetList) {
        this.productPropertySetList = productPropertySetList;
    }
}
