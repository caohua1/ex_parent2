package com.ex.controller.merchant_app_controller.index;

import com.ex.entity.AppointmentSet;
import com.ex.service.AppointmentOrderService;
import com.ex.service.AppointmentSetService;
import com.ex.util.DateAndTimeUtil;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.AppointmentOrderVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appIndex")
//(测试成功)
public class AppointmentSetController {

    @Autowired
    private AppointmentSetService appointmentSetService;
    @Autowired
    private AppointmentOrderService appointmentOrderService;

    /**
     * 商家预约设置
     * @param appointmentSet
     * @return
     */
    @RequestMapping("/insertAppointmentSet")
    public JsonView insertAppointmentSet(AppointmentSet appointmentSet){
        JsonView jsonView = new JsonView();
        try{
            appointmentSet.setCreateTime(new Date());
            Boolean b = appointmentSetService.insertAppointmentSet(appointmentSet);
            if(b==true){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("设置成功");
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("设置失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("设置失败");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }


    /**
     * 商家首页，app端，分页查询所有的预约单
     * @param username 商家账号
     * @param startTime 预约时间（开始）
     * @param endTime 预约时间（结束）
     * @param pageRequest 分页（pageNum pageSize）
     * @return
     */
    @RequestMapping("/appSelectAppointmentOrder")
    public JsonView appSelectAppointmentOrder(Long merchantId,String username, String startTime, String endTime, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            Map map1 = new HashMap();
            if(merchantId!=null){
                map.put("merchantId",merchantId);
            }
            if(username!=null &&!("").equals(username) ){
                map.put("username",username);
            }
            if(startTime!=null && !("").equals(startTime)){
                map.put("startTime", DateAndTimeUtil.convert(startTime));
            }
            if(endTime!=null && !("").equals(endTime)){
                map.put("endTime", DateAndTimeUtil.convert(endTime));
            }
            PageInfo<AppointmentOrderVo> pageInfo = appointmentOrderService.pcSelectAppointmentOrder(map, pageRequest);
            Integer count = appointmentOrderService.selectAppointmentOrderCount(map);
            map1.put("pageInfo",pageInfo);
            map1.put("userCount",count);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("返回数据成功");
            jsonView.setData(map1);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询数据失败");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }


    //根据预约订单id，查询订单详情




}
