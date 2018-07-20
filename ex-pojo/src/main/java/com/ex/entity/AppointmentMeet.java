package com.ex.entity;

import java.util.Date;

public class AppointmentMeet {
    private Long id;//主键
    private Long appointmentPersonId;//约见人id（商家id）
    private Long BeAppointmentPersonId;//被约见人的id
    private String them;//约见主题
    private Date appointmentTime;//约见时间
    private String duration;//约见时长
    private Date createTime;//创建时间
    private int appointmentPersonStatus;//约见人状态（0申请约见(待确认) 1已确认（同意约见）2已确认（不同意约见））
    private int BeAppointmentPersonStatus;//被约见人的状态（0待确认 1通过（同意约见）2未通过（拒绝约见)）

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppointmentPersonId() {
        return appointmentPersonId;
    }

    public void setAppointmentPersonId(Long appointmentPersonId) {
        this.appointmentPersonId = appointmentPersonId;
    }

    public Long getBeAppointmentPersonId() {
        return BeAppointmentPersonId;
    }

    public void setBeAppointmentPersonId(Long beAppointmentPersonId) {
        BeAppointmentPersonId = beAppointmentPersonId;
    }

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getAppointmentPersonStatus() {
        return appointmentPersonStatus;
    }

    public void setAppointmentPersonStatus(int appointmentPersonStatus) {
        this.appointmentPersonStatus = appointmentPersonStatus;
    }

    public int getBeAppointmentPersonStatus() {
        return BeAppointmentPersonStatus;
    }

    public void setBeAppointmentPersonStatus(int beAppointmentPersonStatus) {
        BeAppointmentPersonStatus = beAppointmentPersonStatus;
    }
}
