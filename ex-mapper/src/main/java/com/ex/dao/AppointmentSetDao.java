package com.ex.dao;

import com.ex.entity.AppointmentSet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppointmentSetDao {
    public Integer insertAppointmentSet(AppointmentSet appointmentSet);
    //查询某商家的预约设置
    public AppointmentSet selectAppointmentSet(Long merchantId);
}
