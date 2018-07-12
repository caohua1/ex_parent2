package com.ex.dao;

import com.ex.entity.AppointmentOrder;
import com.ex.vo.AppointmentOrderVo;
import com.ex.vo.ProductInfoManageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppointmentOrderDao {
    public Integer insertAppointmentOrder(AppointmentOrder appointmentOrder);
    public List<AppointmentOrderVo> selectAppointmentOrder(Map map);
    public Integer selectAppointmentOrderCount(Map map);
    public ProductInfoManageVo selectProductPrice(Long id);
}