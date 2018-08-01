package com.ex.vo;

import com.ex.entity.StoreInfo;

import java.io.Serializable;

/**
 * 用户APP可代理店铺的详细信息
 */
public class UserAppAgentStoreInfoVo extends StoreInfo implements Serializable {
    private String typeName;//主营类目
    private String companyName;//店铺名称
    private String companyAddress;//公司地址
    private String linkmanName;//联系人

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }
}
