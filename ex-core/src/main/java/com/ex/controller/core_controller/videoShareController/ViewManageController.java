package com.ex.controller.core_controller.videoShareController;

import com.ex.entity.ViewManage;
import com.ex.service.ViewManageService;
import com.ex.util.DateAndTimeUtil;
import com.ex.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视享配置接口
 */
@RestController
@RequestMapping("/ViewManage")
public class ViewManageController {
    @Autowired
    private ViewManageService viewManageService;

    /**
     *视享配置（增加一条配置数据）
     * @param
     * @return
     */
    @RequestMapping("addViewManage")
    public JsonView addViewManage(Integer videoTime,Integer fileKb,Integer bidTime,Integer videoInitialize,Integer pictureInitialize,String createTime,Integer status){
        JsonView jsonView = new JsonView();
        ViewManage viewManage = new ViewManage();
        try{
            if(videoTime!=null){
                viewManage.setVideoTime(videoTime);
            }if(fileKb!=null){
                viewManage.setFileKb(fileKb);
            }if(bidTime!=null){
                viewManage.setBidTime(bidTime);
            }if(videoInitialize!=null){
                viewManage.setVideoInitialize(videoInitialize);
            }if(pictureInitialize!=null){
                viewManage.setPictureInitialize(pictureInitialize);
            }if(createTime!=null&&createTime!=""){
                viewManage.setCreateTime(DateAndTimeUtil.convert(createTime));
            }if(status!=null){
                viewManage.setStatus(status);
            }
            int i = viewManageService.addViewManage(viewManage);
            if(i>0){
                jsonView.setMessage("增加成功");
            }else {
                jsonView.setMessage("增加失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.fail();
        }
        return jsonView;
    }
}
