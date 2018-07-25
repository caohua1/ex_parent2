package com.ex.controller.core_controller.enioyContractManageController;

import com.ex.service.AppointmentMeetService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.AppointmentMeetVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 运营后台享约管理类
 */
@RestController
@RequestMapping("/enioyContractManage")
public class EnioyContractManageController {

    @Autowired
    private AppointmentMeetService appointmentMeetService;

    /**
     * 查询享约管理所有数据
     * @param page
     * @return
     */
    @RequestMapping("/selectAppointmentMeetVo")
    public JsonView selectAppointmentMeetVo(PageRequest page){
        JsonView jsonView = new JsonView();
        Map staMap = new HashMap();
        try{
                staMap.put("status",1);
            PageInfo<AppointmentMeetVo> appointmentMeetVoPageInfo = appointmentMeetService.selectAppointmentMeetVo(page,staMap);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(appointmentMeetVoPageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 查询享约申请所有数据
     * @param page
     * @return
     */
    @RequestMapping("/applyForAppointmentMeetVo")
    public JsonView applyForAppointmentMeetVo(PageRequest page){
        JsonView jsonView = new JsonView();
        Map staMap = new HashMap();
        try{
            staMap.put("status",0);
            PageInfo<AppointmentMeetVo> appointmentMeetVoPageInfo = appointmentMeetService.selectAppointmentMeetVo(page,staMap);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(appointmentMeetVoPageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }
}
