package com.ex.service.impl;

import com.ex.dao.AppointmentSetDao;
import com.ex.dao.StoreInfoDao;
import com.ex.entity.AppointmentSet;
import com.ex.entity.StoreInfo;
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
    @Autowired
    private StoreInfoDao storeInfoDao;

    /**
     * 商家预约设置（添加数据）
     * @param appointmentSet
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Boolean insertAppointmentSet(AppointmentSet appointmentSet) {
        Integer i = appointmentSetDao.insertAppointmentSet(appointmentSet);
        if(i>0){
            StoreInfo storeInfo = new StoreInfo();
            storeInfo.setIsAppointment(1);//可预约的店铺
            int j = storeInfoDao.updateStoreInfo(storeInfo);//修改店铺的数据，改为可预约
            return j>0 && i>0;
        }
        return false;
    }
}
