package com.ex.controller.login;

import com.ex.entity.UserAppRegist;
import com.ex.service.UserAppRegistService;
import com.ex.util.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName ex_parent
 * @ClassName UserAppRegistController
 * @Description 用户注册Controller
 * @Author sanmu
 * @Date 2018/6/1 11:16
 * @Version 1.0
 **/
@RestController
@RequestMapping("/userapp")
public class UserAppRegistController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserAppRegistService userAppRegistService;

    @RequestMapping("/regist")
    public JsonView UserAppRegistInsert(UserAppRegist userAppRegist) {
         userAppRegistService.insertUserAppRegist(userAppRegist);
        return null;
    }

    @RequestMapping("/selectuserbyid")
    public UserAppRegist SelectUserAppRegistById(long id) {
        return userAppRegistService.selectUserAppRegistById(id);
    }
}
