package com.ex.service.impl;

import com.ex.dao.AppointmentOrderDao;
import com.ex.entity.AppointmentOrder;
import com.ex.service.AppointmentOrder1Service;
import com.ex.util.JsonView;
import com.ex.vo.ProductInfoManageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("ALL")
@Service
public class AppointmentOrder1ServiceImpl implements AppointmentOrder1Service {

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
     * 查询选择的商品的价格
     * @param id
     * @return
     */
    @Override
    public double selectProductPrice(String ids) {
        double prices = 0;
        if(ids!=null && ids.length()>0){
            String[] split = ids.split(",");
            for(String id :split){
                //“——”左边是单价，右边是数量
                String[] split1 = id.split("_");
                //单价*数量
                prices += (appointmentOrderDao.selectProductPrice(Long.parseLong(split1[0])).getResalePrice())*Long.parseLong(split1[1]);
            }
        }
        return prices;
    }
}
