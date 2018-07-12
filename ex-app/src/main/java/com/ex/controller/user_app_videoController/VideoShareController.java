package com.ex.controller.user_app_videoController;

import com.ex.service.UserAppVideoShareService;
import com.ex.util.JsonView;
import com.ex.vo.UserAppVideoShare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/VideoShareController")
public class VideoShareController {

    @Autowired
    private UserAppVideoShareService userAppVideoShareService;

    /**
     * 用户app视享
     * @param fileType
     * @return
     */
    @RequestMapping("selectUserAppVideoShare")
    public JsonView selectUserAppVideoShare(int fileType){
        JsonView jsonView = new JsonView();
        try{
        Map contMap = new HashMap();
        contMap.put("fileType",fileType);
        List<UserAppVideoShare> userAppVideoShares = userAppVideoShareService.selectUserAppVideoShare(contMap);
        if(userAppVideoShares!=null){
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("返回数据成功");
            jsonView.setData(userAppVideoShares);
        }else{
            jsonView.setMessage("暂无数据");
            jsonView.setCode(JsonView.SUCCESS);
        }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询失败");
        }
        return jsonView;
    }

    /**
     * 增加商品点赞次数
     * @param id
     * @param
     * @return
     */
    @RequestMapping("updateDZNum")
    public JsonView updateDZNum(Long id){
        JsonView jsonView = new JsonView();
        Map contMap = new HashMap();
        try{
            if(id!=null){
                contMap.put("id",id);
                contMap.put("DZNum",1);
            }
            int i = userAppVideoShareService.updateUserAppVideoShare(contMap);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("点赞成功");
            }else {
                jsonView.setMessage("点赞失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("失败");
        }
        return jsonView;
    }
}
