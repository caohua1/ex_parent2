package com.ex.controller.merchant_pc_controller.videoEnjoyManageController;

import com.ex.entity.VideoShareManage;
import com.ex.service.VideoShareManageService;
import com.ex.util.DateAndTimeUtil;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/MerchantPCvideo")
public class MerchantPCvideoController {

    @Autowired
    private VideoShareManageService videoShareManageService;


    @RequestMapping("/selectPCvideoShareManage")
    public JsonView selectPCvideoShareManage(PageRequest page,String firstDate,String lastDate,String describe,String fileType){
        Map termMap = new HashMap<String, Object>();
        Map Map = new HashMap<String, Object>();
        JsonView jsonView= new JsonView();
        try{
        if(firstDate!=null&&firstDate!=""){
            termMap.put("firstDate", DateAndTimeUtil.convert(firstDate));
        }if(lastDate!=null&&lastDate!=""){
            termMap.put("lastDate", DateAndTimeUtil.convert(lastDate));
        }if(describe!=null&&describe!=""){
            termMap.put("describe", describe);
        }if(fileType!=null&&fileType!=""){
            termMap.put("describe", Integer.parseInt(fileType));
        }
        PageInfo<VideoShareManage> videoShareManagePageInfo = videoShareManageService.selectPCvideoShareManage(page, termMap);
            Integer integer = videoShareManageService.selectPCvideoShareManageCount(termMap);
            Map.put("entity",videoShareManagePageInfo);
            Map.put("count",integer);
            jsonView.setData(Map);
            jsonView.setMessage("返回数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.fail();
        }
        return jsonView;
    }

    /**
     * 根据uid（商家上传视频文件信息id）删除信息
     * @param uid
     * @return
     */
    @RequestMapping("delectPCvideoShareManageCount")
    public JsonView delectPCvideoShareManageCount(Long uid){
        JsonView jsonView= new JsonView();
        try{
           if(uid!=null){
               Integer i = videoShareManageService.deletePCvideoShareManage(uid);
               if(i>0){
                   jsonView.setMessage("操作数据成功");
               }else {
                   jsonView.setMessage("操作数据失败");
               }
           }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.fail();
        }
        return jsonView;
    }

}
