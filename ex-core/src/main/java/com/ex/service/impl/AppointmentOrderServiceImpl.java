package com.ex.service.impl;

import com.ex.dao.AppointmentOrderDao;
import com.ex.entity.AppointmentOrder;
import com.ex.service.AppointmentOrderService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.AppointmentOrderVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AppointmentOrderServiceImpl implements AppointmentOrderService{

    @Autowired
    private AppointmentOrderDao appointmentOrderDao;

    /**
     * 预订，并支付
     * @param appointmentOrder
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public JsonView insertAppointmentOrder(AppointmentOrder appointmentOrder) {
        JsonView jsonView = new JsonView();
        //支付成功后，才能预订（支付失败不能添加预订信息到数据库）

        //预订成功添加到数据库
        Integer i = appointmentOrderDao.insertAppointmentOrder(appointmentOrder);
        if(i>0){
            jsonView.setMessage("预订成功");
            jsonView.setCode(JsonView.SUCCESS);
        }

        return jsonView;
    }

    /**
     * 商家首页，app端查询所有的预约信息
     * @param map
     * @return
     */
    @Override
    public List<AppointmentOrderVo> appSelectAppointmentOrder(Map map) {
        List<AppointmentOrderVo> appointmentOrderVos = appointmentOrderDao.selectAppointmentOrder(map);
        return appointmentOrderVos;
    }

    /**
     * 商家首页，pc端分页条件查询所有的预约信息
     * @param map
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<AppointmentOrderVo> pcSelectAppointmentOrder(Map map, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<AppointmentOrderVo> appointmentOrderVos = appointmentOrderDao.selectAppointmentOrder(map);
        PageInfo<AppointmentOrderVo> pageInfo = new PageInfo<>(appointmentOrderVos);
        return pageInfo;
    }

    /**
     * 查询预约信息总数量
     * @param map
     * @return
     */
    @Override
    public Integer selectAppointmentOrderCount(Map map) {
        return appointmentOrderDao.selectAppointmentOrderCount(map);
    }
}
