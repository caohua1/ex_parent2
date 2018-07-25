package com.ex.controller.merchant_pc_controller.enioyContractManageController;

import com.ex.service.AppointmentMeetService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.FriendVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Pc端享约管理
 */

/**
 * 商家PC端享约管理
 */
@RestController
@RequestMapping("/PCenioyContractManageController")
public class PCenioyContractManageController {

    private AppointmentMeetService appointmentMeetService;

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
}
