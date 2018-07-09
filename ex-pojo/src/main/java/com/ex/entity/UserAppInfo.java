package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class UserAppInfo implements Serializable {
   /* CREATE TABLE `userapp_info` (
            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
            `registUserId` bigint(20) DEFAULT NULL COMMENT '用户id（与userapp_regist主键关联）',
            `realName` varchar(50) DEFAULT NULL COMMENT '真实姓名',
            `bankName` varchar(50) DEFAULT NULL COMMENT '开户行（哪个银行的银行卡）',
            `bankNum` varchar(50) DEFAULT NULL COMMENT '银行卡号',
            `bankAddress` varchar(100) DEFAULT NULL COMMENT '开户地区',
            `YuE` double(10,2) DEFAULT NULL COMMENT '余额',
            `address` varchar(100) DEFAULT NULL COMMENT '住址',
            `phone` varchar(20) DEFAULT NULL COMMENT '联系手机号',
            `idCard` varchar(20) DEFAULT NULL COMMENT '身份证号',
            `status` int(2) DEFAULT '1' COMMENT '状态（0冻结1解绑 ）',
            `createTime` datetime DEFAULT NULL COMMENT '创建时间',
            `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户绑定银行卡信息';*/

    private Long id;
    private Long registUserId;
    private String realName;
    private String bankName;
    private String bankNum;
    private String bankAddress;
    private Double YuE;
    private String address;
    private String phone;
    private String idCard;
    private Integer status;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegistUserId() {
        return registUserId;
    }

    public void setRegistUserId(Long registUserId) {
        this.registUserId = registUserId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public Double getYuE() {
        return YuE;
    }

    public void setYuE(Double yuE) {
        YuE = yuE;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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
}
