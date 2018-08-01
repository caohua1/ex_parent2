package com.ex.dao;

import com.ex.vo.AppointmentMeetVo;
import com.ex.vo.FriendVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppointmentMeetDao {

    public List<AppointmentMeetVo> selectAppointmentMeetVo(Map staMap);

    public List<FriendVo> selectFriend(Long merchantId);

    public List<FriendVo> selectFriendAdd(Long merchantId);

    public List<AppointmentMeetVo> selectMyAppoinmentMeet(Long merchantId);

    public int updateMyAppoinmentMeet(Long id);

    public List<AppointmentMeetVo> selectApplyAppoinmentMeet(Long merchantId);

    public int updateApplyAppoinmentMeet(Map  conditionMap);

    public int insertFriend(Map  conditionMap);


}
