package com.ex.controller.core_controller.userManageController;
import com.ex.entity.MerchantRegist;
import com.ex.service.MerchantRegistService;
import com.ex.service.MerchantorpersonCheckInService;
import com.ex.util.CustomMD5;
import com.ex.util.DateAndTimeUtil;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.MerchantCheckInVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/merchantManage")
public class MerchantManageController {

    @Autowired
    private MerchantorpersonCheckInService merchantorpersonCheckInService;
    @Autowired
    private MerchantRegistService merchantRegistService;


    /**
     * 查询商家列表（入驻信息）
     * @param merchantCheckInVo(username,industryId,linkmanname,companyname)
     * @param startTime
     * @param endTime
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectMerchantList")
    public JsonView selectMerchantList(MerchantCheckInVo merchantCheckInVo, String startTime, String endTime, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            if(merchantCheckInVo!=null){
                map.put("username",merchantCheckInVo.getUsername());
                map.put("industryId",merchantCheckInVo.getIndustryId());
                map.put("linkmanname",merchantCheckInVo.getLinkmanname());
                map.put("companyname",merchantCheckInVo.getCompanyname());
            }
            if(startTime!=null && !("").equals(startTime)){
                map.put("startTime", DateAndTimeUtil.convert(startTime));
            }
            if(endTime!=null && !("").equals(endTime)){
                map.put("endTime",endTime);
            }
            PageInfo<MerchantCheckInVo> pageInfo = merchantorpersonCheckInService.selectMerchantList(map, pageRequest);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setTodoCount(pageInfo.getSize());
            pageInfo.setSize(pageInfo.getList().size());
            jsonView.setData(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

    /**
     * 根据id查询商家详情
     * @param id
     * @return
     */
    @RequestMapping("/selectMerchantById")
   public JsonView  selectMerchantById(Long id){
        JsonView jsonView = new JsonView();
        try{
            MerchantCheckInVo merchantCheckInVo = merchantorpersonCheckInService.selectMerchantById(id);
            jsonView.setMessage("查询成功");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(merchantCheckInVo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
   }


    /**
     * 修改商家密码，注销
     * @param merchantRegist(id,password新密码,username,或者id,status=0注销)
     * @return
     */
    @RequestMapping("/updateMerchantRegist")
    public JsonView updateMerchantRegist(MerchantRegist merchantRegist){
        JsonView jsonView = new JsonView();
        try{
            merchantRegist.setUpdatetime(new Date());
            if(merchantRegist.getPassword()!=null &&  !("").equals(merchantRegist.getPassword()) && merchantRegist.getUsername()!=null && !("").equals(merchantRegist.getUsername())){
                merchantRegist.setPassword(CustomMD5.passwordAndSalt(merchantRegist.getPassword(),merchantRegist.getUsername()));
            }
            Integer i = merchantRegistService.updateMerchantRegist(merchantRegist);
            if(i>0){
                if(merchantRegist.getPassword()!=null && !("").equals(merchantRegist.getPassword())){
                    jsonView.setMessage("修改密码成功");
                }
                if(merchantRegist.getStatus()!=null){
                    jsonView.setMessage("注销帐号成功");
                }
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("操作失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("操作异常");
        }
        return jsonView;
    }
}
