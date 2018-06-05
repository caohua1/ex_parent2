package com.ex.controller.login;

import com.ex.entity.UserAppRegist;
import com.ex.service.UserAppRegistService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping("/checkSMS")
    public JsonView checkSMS(String code,int state){
//        if(){

//        }
        return JsonView.success(true);
    }

    /**
     * @return com.ex.util.JsonView
     * @author sanmu
     * @Desription 用户注册
     * @date 2018/6/4 11:12
     * @Param [userAppRegist]
     **/
    @RequestMapping(path = "/regist", method = RequestMethod.POST)
    public JsonView userAppRegistInsert(UserAppRegist userAppRegist) {
        logger.info("Request comming to regist user");
        UserAppRegist user = userAppRegistService.checkUserName(userAppRegist.getUsername());
        if (user != null)
            return JsonView.fail("用户名已存在");
        user = userAppRegistService.insertUserAppRegist(userAppRegist);
        return JsonView.success(user);
    }

    @RequestMapping("/selectuserbyid")
    public JsonView selectUserAppRegistById(Long id) {
        logger.info("Request comming to select user");
        UserAppRegist user = userAppRegistService.selectUserAppRegistById(id);
        return JsonView.success(user);
    }

    @RequestMapping("/checkUserName")
    public JsonView checkUserName(String username) {
        logger.info("Request comming to Check username");
        UserAppRegist user = userAppRegistService.checkUserName(username);
        if (user != null)
            return JsonView.fail("用户名已存在");
        return JsonView.success("用户名可用");
    }

    @RequestMapping(path = "/userAppLogin", method = RequestMethod.POST)
    public JsonView userAppLogin(String username, String password) {
        logger.info("Request comming to Login user");
        UserAppRegist user = userAppRegistService.checkUserName(username);
        if (user == null)
            return JsonView.fail("用户名不存在");
        if (!userAppRegistService.checkPassword(user.getPassword(), password, username))
            return JsonView.fail("密码不正确");
        return JsonView.success(user);
    }

    @RequestMapping("/all")
    public JsonView findAll(PageRequest page) {
        logger.info("Request comming to find user list...");
        PageInfo<UserAppRegist> pageInfo = userAppRegistService.findByPage(page);
        return JsonView.success(pageInfo);
    }

}
