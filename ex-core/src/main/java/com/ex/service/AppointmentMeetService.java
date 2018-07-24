package com.ex.service;

import com.ex.util.PageRequest;
import com.ex.vo.AppointmentMeetVo;
import com.ex.vo.FriendVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface AppointmentMeetService {

    public PageInfo<AppointmentMeetVo> selectAppointmentMeetVo(PageRequest page,Map staMap);

    public PageInfo<AppointmentMeetVo> applyForAppointmentMeetVo(PageRequest page,Map staMap);

    public PageInfo<FriendVo> selectFriend(PageRequest page,Long merchantId);

    public PageInfo<FriendVo> selectFriendAdd(PageRequest page,Long merchantId);
}
