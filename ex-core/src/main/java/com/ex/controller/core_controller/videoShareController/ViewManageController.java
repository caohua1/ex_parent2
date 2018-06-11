package com.ex.controller.core_controller.videoShareController;

import com.ex.entity.ViewManage;
import com.ex.service.ViewManageService;
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
     * @param viewManage
     * @return
     */
    @RequestMapping("addViewManage")
    public JsonView addViewManage(ViewManage viewManage,ModelMap map){
        JsonView jsonView = new JsonView();
        int i = viewManageService.addViewManage(viewManage);
        if(i>0){
            map.put("entity",i);
            map.put("result","添加成虫");
            jsonView.setData(map);
        }else {
            map.put("result", "添加失败");
            jsonView.setData(map);
        }
        return jsonView;
    }
}
