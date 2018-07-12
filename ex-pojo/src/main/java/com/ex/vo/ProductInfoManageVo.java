package com.ex.vo;

import com.ex.entity.ProductInfoManage;
import com.ex.entity.ProductPropertySet;

import java.io.Serializable;
import java.util.List;

public class ProductInfoManageVo extends ProductInfoManage implements Serializable{

    private String typeName;
    private String IconStylePic;//商品类型图标样式
    private String brandName;//品牌名称
    private String brandPicUrl;//品牌图标

    List<ProductPropertySet> productPropertySetList;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIconStylePic() {
        return IconStylePic;
    }

    public void setIconStylePic(String iconStylePic) {
        IconStylePic = iconStylePic;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandPicUrl() {
        return brandPicUrl;
    }

    public void setBrandPicUrl(String brandPicUrl) {
        this.brandPicUrl = brandPicUrl;
    }

    public List<ProductPropertySet> getProductPropertySetList() {
        return productPropertySetList;
    }

    public void setProductPropertySetList(List<ProductPropertySet> productPropertySetList) {
        this.productPropertySetList = productPropertySetList;
    }
}
