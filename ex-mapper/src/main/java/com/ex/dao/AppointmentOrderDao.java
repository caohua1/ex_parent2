package com.ex.dao;

import com.ex.entity.AppointmentOrder;
import com.ex.entity.ProductInfoManage;
import com.ex.vo.AppointmentOrderByUserAppVo;
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
    public Integer updateAppointmentOrder(AppointmentOrderVo appointmentOrderVo);
    public AppointmentOrderVo selectAppAppointmentById(Long id);
    //查询预约订单下预约的所有商品信息
    public List<ProductInfoManage> selectProductsByIds (List ProductInfoIds);
    public List<ProductInfoManage> selectProductsByIds1 (String ids);
    //根据用户Id查询该用户所有的预定信息↓
    List<AppointmentOrderByUserAppVo> selectAppointmentOrderByUserApp(Long registUserId);
    //=====================================
    //订单管理模块，查询所有的预约订单
    public List<AppointmentOrderVo> selectAppontmentOrdersByParam(AppointmentOrderVo appointmentOrderVo);
}
