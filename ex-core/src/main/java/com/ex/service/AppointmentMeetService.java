package com.ex.service;

import com.ex.util.PageRequest;
import com.ex.vo.AppointmentMeetVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface AppointmentMeetService {

    public PageInfo<AppointmentMeetVo> selectAppointmentMeetVo(PageRequest page,Map staMap);

    public PageInfo<AppointmentMeetVo> applyForAppointmentMeetVo(PageRequest page,Map staMap);
}
