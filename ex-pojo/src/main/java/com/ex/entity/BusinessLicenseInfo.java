package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class BusinessLicenseInfo implements Serializable {
    private Integer id;

    private Integer type;

    private Long merchantid;

    private Long registuserid;

    private String companyname;

    private String legalperson;

    private String companyaddress;

    private String establishmentdate;

    private String validityperiod;

    private String merchantidnumber;

    private String socialcreditcode;

    private String idcard;

    private String realname;

    private Integer sex;

    private String birthday;

    private String address;

    private String national;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Long merchantid) {
        this.merchantid = merchantid;
    }

    public Long getRegistuserid() {
        return registuserid;
    }

    public void setRegistuserid(Long registuserid) {
        this.registuserid = registuserid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }

    public String getEstablishmentdate() {
        return establishmentdate;
    }

    public void setEstablishmentdate(String establishmentdate) {
        this.establishmentdate = establishmentdate;
    }

    public String getValidityperiod() {
        return validityperiod;
    }

    public void setValidityperiod(String validityperiod) {
        this.validityperiod = validityperiod;
    }

    public String getMerchantidnumber() {
        return merchantidnumber;
    }

    public void setMerchantidnumber(String merchantidnumber) {
        this.merchantidnumber = merchantidnumber;
    }

    public String getSocialcreditcode() {
        return socialcreditcode;
    }

    public void setSocialcreditcode(String socialcreditcode) {
        this.socialcreditcode = socialcreditcode;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}