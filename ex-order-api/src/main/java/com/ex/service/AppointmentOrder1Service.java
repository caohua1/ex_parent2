package com.ex.service;

import com.aliyuncs.exceptions.ClientException;
import com.ex.entity.AppointmentOrder;
import com.ex.util.JsonView;
import com.ex.vo.AppointmentOrderVo;
import com.ex.vo.ProductInfoManageVo;

public interface AppointmentOrder1Service {
    public JsonView insertAppointmentOrder(AppointmentOrder appointmentOrder);
    public double selectProductPrice(String ids);
    //取消预约订单（用户取消3，商家取消4）
    public Boolean updateAppointmentOrder(AppointmentOrderVo appointmentOrderVo) throws ClientException;
}
