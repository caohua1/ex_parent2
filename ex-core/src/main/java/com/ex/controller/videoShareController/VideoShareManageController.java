package com.ex.controller.videoShareController;

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

/**
 * 视享管理接口
 */
@RestController
@RequestMapping("/VideoShareManage")
public class VideoShareManageController {

    @Autowired
    private VideoShareManageService videoShareManageService;

    /**
     * @param page 分页
     * @param firstDate 开始时间
     * @param lastDate 结束时间
     * @param username 发布者
     * @param describe 说说（关键字）
     * @param rank 是否按竞价排名从高到底
     * @param fileType 类型
     * @return
     */
    @RequestMapping("selectVideoShareManage")
    public JsonView selectVideoShareManage(PageRequest page,String firstDate,String lastDate,String username,String describe,String rank,String fileType){
        Map termMap = new HashMap<String, Object>();
        Map dataMap = new HashMap<String, Object>();
        JsonView jsonView= new JsonView();
        try{
            if(firstDate!=null&&firstDate!=""){
                termMap.put("firstDate", DateAndTimeUtil.convert(firstDate));
            }if(lastDate!=null&&lastDate!=""){
                termMap.put("lastDate", DateAndTimeUtil.convert(lastDate));
            }if(username!=null&&username!=""){
                termMap.put("username", username);
            }if(describe!=null&&describe!=""){
                termMap.put("describe", describe);
            }if(rank!=null&&rank!=""){
                termMap.put("rank", rank);
            }if(fileType!=null&&fileType!=""){
                termMap.put("fileType", fileType);
            }
            PageInfo<VideoShareManage> videoShareManagePageInfo = videoShareManageService.selectVideoShareManage(page, termMap);
            Integer count = videoShareManageService.selectVideoShareManageCount(termMap);
            dataMap.put("videoShareData",videoShareManagePageInfo);
            dataMap.put("count",count);
            jsonView.setData(dataMap);
            jsonView.setMessage("访问成功");
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.fail();
        }
        return jsonView;
    }
}
