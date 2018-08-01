package com.ex.controller.merchant_pc_controller.enioyContractManageController;

import com.ex.entity.MerchantorpersonCheckIn;
import com.ex.service.AppointmentMeetService;
import com.ex.service.MerchantorpersonCheckInService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.AppointmentMeetVo;
import com.ex.vo.FriendVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
/**
 * Pc端享约管理
 */

/**
 * 商家PC端享约管理
 */
@RestController
@RequestMapping("/PCenioyContractManager")
public class PCenioyContractManageController {

    @Autowired
    private AppointmentMeetService appointmentMeetService;

    @Autowired
    private MerchantorpersonCheckInService merchantorpersonCheckInService;

    /**
     * 查询我加的享友数据
     * @param page
     * @param merchantId
     * @return
     */
    @RequestMapping("selectAddFriend")
    public JsonView selectAddFriend(PageRequest page, Long merchantId){
        JsonView jsonView = new JsonView();
        try{
            if(merchantId!=null){
                PageInfo<FriendVo> friendVoPageInfo = appointmentMeetService.selectFriend(page, merchantId);
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询成功");
                jsonView.setData(friendVoPageInfo);
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 查询加我的享友数据
     * @return
     */
    @RequestMapping("selectFriendAdd")
    public JsonView selectFriendAdd(PageRequest page, Long merchantId){
        JsonView jsonView = new JsonView();
        try{
            if(merchantId!=null){
                PageInfo<FriendVo> friendVoPageInfo = appointmentMeetService.selectFriendAdd(page, merchantId);
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询成功");
                jsonView.setData(friendVoPageInfo);
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 查询PC端相约管理我的享约数据
     * @return
     */
    @RequestMapping("selectMyAppoinmentMeet")
    public JsonView selectMyAppoinmentMeet(PageRequest page, Long merchantId){
        JsonView jsonView = new JsonView();
        try{
           if(merchantId!=null){
               PageInfo<AppointmentMeetVo> appointmentMeetVoPageInfo = appointmentMeetService.selectMyAppoinmentMeet(page, merchantId);
               jsonView.setCode(JsonView.SUCCESS);
               jsonView.setMessage("查询成功");
               jsonView.setData(appointmentMeetVoPageInfo);
           }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 约见人取消享约
     * @param id
     * @return
     */
    @RequestMapping("updateMyAppoinmentMeet")
    public JsonView updateMyAppoinmentMeet(Long id){
        JsonView jsonView = new JsonView();
        try{
            if(id!=null){
                int i = appointmentMeetService.updateMyAppoinmentMeet(id);
                if(i>0){
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setMessage("修改成功");
                }else {
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setMessage("修改失败");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 查询享约申请数据
     * @return
     */
    @RequestMapping("selectApplyAppoinmentMeet")
    public JsonView selectApplyAppoinmentMeet(PageRequest page, Long merchantId){
        JsonView jsonView = new JsonView();
        try{
            if(merchantId!=null){
                PageInfo<AppointmentMeetVo> appointmentMeetVoPageInfo = appointmentMeetService.selectApplyAppoinmentMeet(page, merchantId);
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询成功");
                jsonView.setData(appointmentMeetVoPageInfo);
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 修改享约申请数据状态（修改通过或者不通过）
     * @param BeAppointmentPersonStatus
     * @param id
     * @return
     */
    public JsonView updateApplyAppoinmentMeet(int BeAppointmentPersonStatus,Long id){
        JsonView jsonView = new JsonView();
        Map conditionMap = new HashMap();
        try{
            if(id!=null){
                conditionMap.put("id",id);
                if(BeAppointmentPersonStatus==1||BeAppointmentPersonStatus==2){
                    conditionMap.put("BeAppointmentPersonStatus",BeAppointmentPersonStatus);
                    int i = appointmentMeetService.updateApplyAppoinmentMeet(conditionMap);
                    if(i>0){
                        jsonView.setCode(JsonView.SUCCESS);
                        jsonView.setMessage("修改成功");
                    }else {
                        jsonView.setCode(JsonView.SUCCESS);
                        jsonView.setMessage("修改失败");
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 享约管理查询所有入驻商家信息（约吧）
     * @param page
     * @return
     */
    @RequestMapping("selectAllMerchant")
    public JsonView selectAllMerchant(PageRequest page){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<MerchantorpersonCheckIn> byPage = merchantorpersonCheckInService.findByPage(page);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(byPage);
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 添加享友
     * @param merchantId
     * @param friendId
     * @return
     */
    @RequestMapping("insertFriend")
    public JsonView insertFriend(Long merchantId,Long friendId){
        JsonView jsonView = new JsonView();
        Map conditionMap = new HashMap();
        try{
            if(merchantId!=null&friendId!=null){
                conditionMap.put("merchantId",merchantId);
                conditionMap.put("friendId",friendId);
                conditionMap.put("invitStatus",0);
                conditionMap.put("BeInvitStatus",0);
                int i = appointmentMeetService.insertFriend(conditionMap);
                if(i>0){
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setMessage("添加成功");
                }else {
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setMessage("添加失败");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }
}
