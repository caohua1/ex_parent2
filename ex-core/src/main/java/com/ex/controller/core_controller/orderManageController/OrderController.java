package com.ex.controller.core_controller.orderManageController;

import com.ex.service.AppointmentOrder1Service;
import com.ex.service.PCOrderService;
import com.ex.service.ShareOrderService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.AppointmentOrderVo;
import com.ex.vo.OrderVo;
import com.ex.vo.PCOrderVo;
import com.ex.vo.ShareOrderInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/core_order")
@RestController
public class OrderController {

    @Autowired
    private AppointmentOrder1Service appointmentOrder1Service;
    @Autowired
    private ShareOrderService shareOrderService;
    @Autowired
    private PCOrderService pcOrderService;

    //销售订单

    /**
     *
     * @param pcOrderVo
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectAllOrder")
    public JsonView selectAllOrder(PCOrderVo pcOrderVo,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<PCOrderVo> pcOrderVoPageInfo = pcOrderService.selectAllOrder(pcOrderVo, pageRequest);
            Map map = new HashMap();
            map.put("pageInfo",pcOrderVoPageInfo);
            map.put("count",pcOrderVoPageInfo.getSize());
            if(pcOrderVoPageInfo!=null && pcOrderVoPageInfo.getList().size()>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询成功");
                jsonView.setData(map);
            }else{
                jsonView.setMessage("暂无数据");
                jsonView.setCode(JsonView.ERROR);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    //预定订单
    /**
     * 后台订单管理模块，预约订单
     * @param appointmentOrderVo（startTime,endTime,username,registUserName,orderNum,status,,pageNum,pageSize）
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectAppointmentOrdersByParam")
    public JsonView selectAppointmentOrdersByParam(AppointmentOrderVo appointmentOrderVo, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<AppointmentOrderVo> pageInfo = appointmentOrder1Service.selectAppontmentOrdersByParam(appointmentOrderVo, pageRequest);
            int count = pageInfo.getSize();
            Map map = new HashMap();
            map.put("count",count);
            map.put("pageInfo",pageInfo);
            if(pageInfo.getList().size()>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询成功");
                jsonView.setData(map);
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("暂无数据");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }


    //查看预约订单的详情
    /**
     * 查看预约订单的详情
     * @param id
     * @return
     */
    @RequestMapping("/selectAppAppointmentById")
    public JsonView selectAppAppointmentById(Long id){
        JsonView jsonView = new JsonView();
        try{
            AppointmentOrderVo appointmentOrderVo = appointmentOrder1Service.selectAppAppointmentById(id);
            jsonView.setMessage("查询成功");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(appointmentOrderVo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }


    //分享订单

    /**
     * 后台，订单管理模块，分享订单查询
     * @param shareOrderInfoVo
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectAllShareOrderByParam")
    public JsonView selectAllShareOrderByParam(ShareOrderInfoVo shareOrderInfoVo,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<ShareOrderInfoVo> pageInfo = shareOrderService.selectAllShareOrderByParam(shareOrderInfoVo, pageRequest);
            Map map = new HashMap();
            map.put("pageInfo",pageInfo);
            map.put("count",pageInfo.getSize());
            if(pageInfo.getList().size()>0){
                jsonView.setMessage("查询成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(map);
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("暂无数据");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

    //订单详情

    /**
     * 分享订单(销售订单)详情
     * @param id
     * @return
     */
    @RequestMapping("/selectShareOrderInfoById")
    public JsonView selectShareOrderInfoById(Long id){
        JsonView jsonView = new JsonView();
        try{
            OrderVo orderVo = pcOrderService.selectShareOrderInfoById(id);
            orderVo.setProductDJ((orderVo.getOrderMoney()-orderVo.getPostage())/orderVo.getProductNum());
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(orderVo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }
}
