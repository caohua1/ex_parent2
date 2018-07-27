package com.ex.controller.user_app_controller.orderController;

import com.ex.service.AppointmentOrder1Service;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.AppointmentOrderByUserAppVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/order")
public class AppointmentOrderController {

    @Autowired
    private AppointmentOrder1Service appointmentOrder1Service;

    /**
     * 根据用户Id查询该用户所有的预定信息
     * @param registUserId
     * @param page
     * @return
     */
    @RequestMapping("/selectAppointmentOrderByUserApp")
    public JsonView selectAppointmentOrderByUserApp(Long registUserId, PageRequest page){
        JsonView jsonView = new JsonView();
        try{
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
            List<AppointmentOrderByUserAppVo> appointmentOrderByUserAppVos = appointmentOrder1Service.selectAppointmentOrderByUserApp(registUserId);
            PageInfo<AppointmentOrderByUserAppVo> pageInfo = new PageInfo<>(appointmentOrderByUserAppVos);
            jsonView.setData(pageInfo);
            jsonView.setMessage("请求成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setTodoCount(appointmentOrderByUserAppVos.size());
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

}
