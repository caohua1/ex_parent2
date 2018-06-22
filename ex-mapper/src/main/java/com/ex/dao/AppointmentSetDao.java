package com.ex.dao;

import com.ex.entity.AppointmentSet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppointmentSetDao {
    public Integer insertAppointmentSet(AppointmentSet appointmentSet);
}
