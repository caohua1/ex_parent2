package com.ex.dao;

import com.ex.vo.AppointmentMeetVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppointmentMeetDao {

    public List<AppointmentMeetVo> selectAppointmentMeetVo(Map staMap);
}
