package com.ex.service;

import com.ex.entity.AppointmentOrder;
import com.ex.util.JsonView;
import com.ex.vo.ProductInfoManageVo;

public interface AppointmentOrder1Service {
    public JsonView insertAppointmentOrder(AppointmentOrder appointmentOrder);
    public double selectProductPrice(String ids);
}
