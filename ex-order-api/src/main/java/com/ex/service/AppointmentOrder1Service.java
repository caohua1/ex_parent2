package com.ex.service;

import com.aliyuncs.exceptions.ClientException;
import com.ex.entity.AppointmentOrder;
import com.ex.entity.ProductInfoManage;
import com.ex.util.JsonView;
import com.ex.vo.AppointmentOrderByUserAppVo;
import com.ex.vo.AppointmentOrderVo;
import com.ex.vo.ProductInfoManageVo;

import java.util.List;

public interface AppointmentOrder1Service {
    public JsonView insertAppointmentOrder(AppointmentOrder appointmentOrder);
    public double selectProductPrice(String ids);
    //取消预约订单（用户取消3，商家取消4）
    public Boolean updateAppointmentOrder(AppointmentOrderVo appointmentOrderVo) throws ClientException;
    //查询预约订单下预约的所有商品信息
    public List<ProductInfoManage> selectProductsByIds(String ProductInfoIds);

    //根据用户Id查询该用户所有的预定信息↓
    List<AppointmentOrderByUserAppVo> selectAppointmentOrderByUserApp(Long registUserId);
}
