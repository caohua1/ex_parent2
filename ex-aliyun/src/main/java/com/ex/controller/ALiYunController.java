package com.ex.controller;

import com.ex.util.ALiYunUtil;
import com.ex.util.JsonView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aliyun")
public class ALiYunController {

    @RequestMapping("/ALIBB_RPBasic")
    public JsonView ALIBB_RPBasic(){
        JsonView jsonView = new JsonView();
        System.out.println("进入实人认证系统");
        String url = "http://localhost:8095/aliyun/ALIBB_RPBasic";
        if (ALiYunUtil.ALIBB_RPBasic(url)){
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("认证通过!");
        }else{
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("认证不通过!");
        }
        return jsonView;
    }

}
