package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MerchantorpersonCheckIn {
    private Long id;

    private Long merchantid;

    private Integer checkintype;

    private String linkmanname;

    private String companyname;

    private String companycode;

    private String legalname;

    private String companyaddress;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date companycreatetime;

    private Double registmoney;

    private String charterpicurl;

    private String idcardpicurlZ;

    private String idcardpicurlF;

    private String idcardpic;

    private String industry;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date checkintime;

    private Double checkinmoney;

    private Integer checkinmoneystatus;

    private Integer checkinpaystatus;

    private Integer status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Long merchantid) {
        this.merchantid = merchantid;
    }

    public Integer getCheckintype() {
        return checkintype;
    }

    public void setCheckintype(Integer checkintype) {
        this.checkintype = checkintype;
    }

    public String getLinkmanname() {
        return linkmanname;
    }

    public void setLinkmanname(String linkmanname) {
        this.linkmanname = linkmanname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getLegalname() {
        return legalname;
    }

    public void setLegalname(String legalname) {
        this.legalname = legalname;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }

    public Date getCompanycreatetime() {
        return companycreatetime;
    }

    public void setCompanycreatetime(Date companycreatetime) {
        this.companycreatetime = companycreatetime;
    }

    public Double getRegistmoney() {
        return registmoney;
    }

    public void setRegistmoney(Double registmoney) {
        this.registmoney = registmoney;
    }

    public String getCharterpicurl() {
        return charterpicurl;
    }

    public void setCharterpicurl(String charterpicurl) {
        this.charterpicurl = charterpicurl;
    }

    public String getIdcardpicurlZ() {
        return idcardpicurlZ;
    }

    public void setIdcardpicurlZ(String idcardpicurlZ) {
        this.idcardpicurlZ = idcardpicurlZ;
    }

    public String getIdcardpicurlF() {
        return idcardpicurlF;
    }

    public void setIdcardpicurlF(String idcardpicurlF) {
        this.idcardpicurlF = idcardpicurlF;
    }

    public String getIdcardpic() {
        return idcardpic;
    }

    public void setIdcardpic(String idcardpic) {
        this.idcardpic = idcardpic;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Date getCheckintime() {
        return checkintime;
    }

    public void setCheckintime(Date checkintime) {
        this.checkintime = checkintime;
    }

    public Double getCheckinmoney() {
        return checkinmoney;
    }

    public void setCheckinmoney(Double checkinmoney) {
        this.checkinmoney = checkinmoney;
    }

    public Integer getCheckinmoneystatus() {
        return checkinmoneystatus;
    }

    public void setCheckinmoneystatus(Integer checkinmoneystatus) {
        this.checkinmoneystatus = checkinmoneystatus;
    }

    public Integer getCheckinpaystatus() {
        return checkinpaystatus;
    }

    public void setCheckinpaystatus(Integer checkinpaystatus) {
        this.checkinpaystatus = checkinpaystatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}