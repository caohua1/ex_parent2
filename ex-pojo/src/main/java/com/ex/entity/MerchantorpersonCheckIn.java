package com.ex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MerchantorpersonCheckIn {
    private Long id;

    private Long merchantId;

    private Integer checkintype;

    private Long invitercode;

    private String linkmanname;

    private String companyname;

    private String companycode;

    private String legalname;

    private String companyaddress;

    private String companycreatetime;

    private String charterpicurl;

    private String idcardpicurlZ;

    private String idcardpicurlF;

    private String idcardpic;

    private Long industryId;

    private Date checkintime;

    private Double checkinmoney;

    private Integer checkinpaytype;

    private Integer checkinpaystatus;

    private String causeby;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatetime;

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

    public Integer getCheckintype() {
        return checkintype;
    }

    public void setCheckintype(Integer checkintype) {
        this.checkintype = checkintype;
    }

    public Long getInvitercode() {
        return invitercode;
    }

    public void setInvitercode(Long invitercode) {
        this.invitercode = invitercode;
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

    public String getCompanycreatetime() {
        return companycreatetime;
    }

    public void setCompanycreatetime(String companycreatetime) {
        this.companycreatetime = companycreatetime;
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

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
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

    public Integer getCheckinpaytype() {
        return checkinpaytype;
    }

    public void setCheckinpaytype(Integer checkinpaytype) {
        this.checkinpaytype = checkinpaytype;
    }

    public Integer getCheckinpaystatus() {
        return checkinpaystatus;
    }

    public void setCheckinpaystatus(Integer checkinpaystatus) {
        this.checkinpaystatus = checkinpaystatus;
    }

    public String getCauseby() {
        return causeby;
    }

    public void setCauseby(String causeby) {
        this.causeby = causeby;
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