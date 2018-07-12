package com.ex.service.impl;

import com.ex.dao.AppointmentSetDao;
import com.ex.entity.AppointmentSet;
import com.ex.service.AppointmentSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppointmentSetServiceImpl implements AppointmentSetService {

    @Autowired
    private AppointmentSetDao appointmentSetDao;

    /**
     * 商家预约设置（添加数据）
     * @param appointmentSet
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Integer insertAppointmentSet(AppointmentSet appointmentSet) {
        return appointmentSetDao.insertAppointmentSet(appointmentSet);
    }
}
