package com.ex.controller.user_app_controller.exController;

import com.ex.entity.AppointmentOrder;
import com.ex.service.AppointmentOrder1Service;
import com.ex.util.JsonView;
import com.ex.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/merchantStore")
//商家店铺、预订和评价(已测试，成功)
public class MerchantStoreController {

    @Autowired
    private AppointmentOrder1Service appointmentOrderService;

    /**
     * 用户预订商品
     * registUserId,productInfoId商品id,registUsername用户账号,contactsName联系人,contactsPhone联系电话,
     peopleNum预定人数,orderNum预定编号,merchantName商家名称,productName产品名称,appointmentMoney金额,appointmentTime时间,
     createTime,remark备注,payWay支付方式,payStatus支付状态
     * @param appointmentOrder
     * @return
     */
    @RequestMapping("/insertAppointmentOrder")
    public JsonView insertAppointmentOrder(AppointmentOrder appointmentOrder){
        try{
            appointmentOrder.setOrderNum(UUIDUtil.getOrderIdByUUId());
            System.out.println(UUIDUtil.getOrderIdByUUId());
            appointmentOrder.setCreateTime(new Date());
            JsonView jsonView = appointmentOrderService.insertAppointmentOrder(appointmentOrder);
            return jsonView;
        }catch(Exception e){
            e.printStackTrace();
        }
        return JsonView.fail("预订失败");
    }

}
