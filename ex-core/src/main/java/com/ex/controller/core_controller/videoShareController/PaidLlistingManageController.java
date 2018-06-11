package com.ex.controller.core_controller.videoShareController;

import com.ex.entity.PaidLlistingManage;
import com.ex.service.PaidLlistingManageService;
import com.ex.util.JsonResult;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *视享竞价排名接口
 */
@RestController
@RequestMapping("/PaidLlistingManage")
public class PaidLlistingManageController {
    @Autowired
    private PaidLlistingManageService paidLlistingManageService;

    /**
     *视享竞价排名（查询）
     * @param page
     * @param username
     * @param describe
     * @param fileType
     * @param id
     * @param maxMoney
     * @param mixMoney
     * @return
     */
    @RequestMapping("selectPaidLlisting")
    public JsonView selectPaidLlisting(PageRequest page,String username,String describe,String fileType,Long id, Double maxMoney,Double mixMoney){
        Map conditionMap = new HashMap<String, Object>();
        Map dataMap = new HashMap<String, Object>();
        JsonView jsonView= new JsonView();
        try{
            if(username!=null&&username!=""){
                conditionMap.put("username",username);
            }if(describe!=null&&describe!=""){
                conditionMap.put("describe",describe);
            }if(fileType!=null&&fileType!=""){
                conditionMap.put("fileType",Integer.parseInt(fileType));
            }if(id!=null){
                conditionMap.put("id",id);
            }if(mixMoney!=null){
                conditionMap.put("mixMoney",mixMoney);
            }if(maxMoney!=null){
                conditionMap.put("maxMoney",maxMoney);
            }
            PageInfo<PaidLlistingManage> paidLlistingManagePageInfo = paidLlistingManageService.selectPaidLlisting(page, conditionMap);
            dataMap.put("entity",paidLlistingManagePageInfo);
            dataMap.put("result","访问成功");
            jsonView.setData(dataMap);
        }catch(Exception e){
            e.printStackTrace();
        }
        return jsonView;
    }

    /**
     * 视享管理根据id删除数据
     * @param id
     * @return
     */
    @RequestMapping("delectPaidLlisting")
    public JsonResult delectPaidLlisting(Long id){
        JsonResult result = new JsonResult();
        Map dataMap = new HashMap<String, Object>();
        try{
            int i = paidLlistingManageService.delectPaidLlisting(id);
            if(i>0){
                dataMap.put("entity",i);
                result.setData(dataMap);
                result.setState(JsonResult.SUCCESS);
                result.setMessage("操作数据成功");
            }else {
                result.setState(JsonResult.ERROR);
                result.setMessage("操作数据失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
