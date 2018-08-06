package com.ex.service;

import com.ex.entity.AppointmentOrder;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.AppointmentOrderVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface AppointmentOrderService {
    public JsonView insertAppointmentOrder(AppointmentOrder appointmentOrder);
   //app端不需要分页
    public List<AppointmentOrderVo> appSelectAppointmentOrder(Map map);
    //pc端需要分页
    public PageInfo<AppointmentOrderVo> pcSelectAppointmentOrder(Map map, PageRequest pageRequest);
    public Integer selectAppointmentOrderCount(Map map);

    //查询某预约订单的详情
    public AppointmentOrderVo selectAppointOrderInfo(Long id);
}
