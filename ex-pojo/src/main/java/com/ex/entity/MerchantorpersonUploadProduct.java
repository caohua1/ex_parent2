package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 上传商品视频（图片）
 */

public class MerchantorpersonUploadProduct {
    private Long id;
    private Long merchantId;
    private Long productClassifyId;
    private Long productInfoId;
    private String productNo;
    private String fileUrl;
    private int fileType;
    private String describe;
    private Long musicId;
    private String link;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date uploadfileTime;
    private double price;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private int status;
    private int playNum;
    private int storeNum;
    private int saleNum;
    private int distribution;

    public MerchantorpersonUploadProduct() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public MerchantorpersonUploadProduct(Long id, Long merchantId, Long productClassifyId, Long productInfoId, String productNo, String fileUrl, int fileType, String describe, Long musicId, String link, Date uploadfileTime, double price, Date updateTime, int status, int playNum, int storeNum, int saleNum, int distribution) {
        this.id = id;
        this.merchantId = merchantId;
        this.productClassifyId = productClassifyId;
        this.productInfoId = productInfoId;
        this.productNo = productNo;
        this.fileUrl = fileUrl;
        this.fileType = fileType;
        this.describe = describe;
        this.musicId = musicId;
        this.link = link;
        this.uploadfileTime = uploadfileTime;
        this.price = price;
        this.updateTime = updateTime;
        this.status = status;
        this.playNum = playNum;
        this.storeNum = storeNum;
        this.saleNum = saleNum;
        this.distribution = distribution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getProductClassifyId() {
        return productClassifyId;
    }

    public void setProductClassifyId(Long productClassifyId) {
        this.productClassifyId = productClassifyId;
    }

    public Long getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Long getMusicId() {
        return musicId;
    }

    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getUploadfileTime() {
        return uploadfileTime;
    }

    public void setUploadfileTime(Date uploadfileTime) {
        this.uploadfileTime = uploadfileTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    public int getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(int storeNum) {
        this.storeNum = storeNum;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public int getDistribution() {
        return distribution;
    }

    public void setDistribution(int distribution) {
        this.distribution = distribution;
    }
}
