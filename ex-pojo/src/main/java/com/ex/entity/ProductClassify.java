package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProductClassify implements Serializable {


    private Long id;
    private String typeName;//商品类型（美食，健身）
    private Long parentId;//父级id
    private Integer levelNum;//类目级别（0一级 1二级 3三级）
    private String IconStylePic;//图标样式
    private String describe;//分类描述
    private Integer sort;//分类排序（按默认的展示）
    private Integer status;//状态（0不显示 1显示）
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private List<ProductClassify> productClassifyList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(Integer levelNum) {
        this.levelNum = levelNum;
    }

    public String getIconStylePic() {
        return IconStylePic;
    }

    public void setIconStylePic(String iconStylePic) {
        IconStylePic = iconStylePic;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<ProductClassify> getProductClassifyList() {
        return productClassifyList;
    }

    public void setProductClassifyList(List<ProductClassify> productClassifyList) {
        this.productClassifyList = productClassifyList;
    }
}
