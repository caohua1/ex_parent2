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

    /**
     * 查询PC端相约管理我的享约数据
     * @param page
     * @param merchantId
     * @return
     */
    @Override
    public PageInfo<AppointmentMeetVo> selectMyAppoinmentMeet(PageRequest page, Long merchantId) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AppointmentMeetVo> appointmentMeetVos = appointmentMeetDao.selectMyAppoinmentMeet(merchantId);
        PageInfo<AppointmentMeetVo> appointmentMeetVoPageInfo = new PageInfo<>(appointmentMeetVos);
        return appointmentMeetVoPageInfo;
    }

    /**
     * 约见人取消享约
     * @param id
     * @return
     */
    @Override
    public int updateMyAppoinmentMeet(Long id) {
        return appointmentMeetDao.updateMyAppoinmentMeet(id);
    }

    /**
     * 查询享约申请数据
     * @param page
     * @param merchantId
     * @return
     */
    @Override
    public PageInfo<AppointmentMeetVo> selectApplyAppoinmentMeet(PageRequest page, Long merchantId) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AppointmentMeetVo> appointmentMeetVos = appointmentMeetDao.selectApplyAppoinmentMeet(merchantId);
        PageInfo<AppointmentMeetVo> appointmentMeetVoPageInfo = new PageInfo<>(appointmentMeetVos);
        return appointmentMeetVoPageInfo;
    }

    /**
     * 修改享约申请数据状态（修改通过或者不通过）
     * @param conditionMap
     * @return
     */
    @Override
    public int updateApplyAppoinmentMeet(Map conditionMap) {
        return appointmentMeetDao.updateApplyAppoinmentMeet(conditionMap);
    }


    /**
     * 添加享友
     * @param conditionMap
     * @return
     */
    @Override
    public int insertFriend(Map conditionMap) {
        return appointmentMeetDao.insertFriend(conditionMap);
    }



}