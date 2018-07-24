package com.ex.service.impl;

import com.ex.dao.AppointmentMeetDao;
import com.ex.service.AppointmentMeetService;
import com.ex.util.PageRequest;
import com.ex.vo.AppointmentMeetVo;
import com.ex.vo.FriendVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AppointmentMeetServiceimpl implements AppointmentMeetService {

    @Autowired
    private AppointmentMeetDao appointmentMeetDao;

    /**
     * 查询享约管理所有数据信息
     * @param page
     * @return
     */
    @Override
    public PageInfo<AppointmentMeetVo> selectAppointmentMeetVo(PageRequest page,Map staMap) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AppointmentMeetVo> appointmentMeetVos = appointmentMeetDao.selectAppointmentMeetVo(staMap);
        PageInfo<AppointmentMeetVo> appointmentMeetVoPageInfo = new PageInfo<>(appointmentMeetVos);
        return appointmentMeetVoPageInfo;
    }

    /**
     * 查询享约申请所有数据信息
     * @param page
     * @return
     */
    @Override
    public PageInfo<AppointmentMeetVo> applyForAppointmentMeetVo(PageRequest page,Map staMap) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AppointmentMeetVo> appointmentMeetVos = appointmentMeetDao.selectAppointmentMeetVo(staMap);
        PageInfo<AppointmentMeetVo> appointmentMeetVoPageInfo = new PageInfo<>(appointmentMeetVos);
        return appointmentMeetVoPageInfo;
    }

    /**
     * PC端查询我加的享友
     * @param page
     * @param merchantId
     * @return
     */
    @Override
    public PageInfo<FriendVo> selectFriend(PageRequest page,Long merchantId) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<FriendVo> friendVos = appointmentMeetDao.selectFriend(merchantId);
        PageInfo<FriendVo> friendVoPageInfo = new PageInfo<>(friendVos);
        return friendVoPageInfo;
    }

    /**
     * PC端查询加我的享友数据
     * @param merchantId
     * @return
     */
    @Override
    public PageInfo<FriendVo> selectFriendAdd(PageRequest page,Long merchantId) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<FriendVo> friendVs = appointmentMeetDao.selectFriendAdd(merchantId);
        PageInfo<FriendVo> voPageInfo = new PageInfo<>(friendVs);
        return voPageInfo;
    }
}