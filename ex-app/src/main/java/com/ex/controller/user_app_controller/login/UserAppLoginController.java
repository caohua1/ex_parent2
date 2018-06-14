package com.ex.controller.user_app_controller.login;

import com.ex.entity.UserAppRegist;
import com.ex.service.UserAppRegistService;
import com.ex.util.CustomMD5;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ProjectName ex_parent
 * @ClassName UserAppRegistController
 * @Description TODO 用户注册Controller
 * @Author sanmu=
 * @Version 1.0
 **/
@RestController
@RequestMapping("/userapp/login")
public class UserAppLoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserAppRegistService userAppRegistService;

    /**
     * @param username 用户名
     * @return
     * @Desription TODO 检查用户名是否存在
     */
    @RequestMapping("/checkUserName")
    public JsonView checkUserName(String username) {
        try {
            logger.info("Request comming to Check username");
            UserAppRegist user = userAppRegistService.userLoginOrCheckUserName(username);
            if (user != null)
                return JsonView.fail("用户名已存在");
            return JsonView.success("用户名可用");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(e.getMessage());
        }
    }

    /**
     * @return com.ex.util.JsonView
     * @author sanmu
     * @Desription TODO 用户注册
     * @date 2018/6/4 11:12
     * @Param [userAppRegist] 用户对象
     **/
    @RequestMapping(path = "/regist", method = RequestMethod.POST)
    public JsonView userAppRegistInsert(UserAppRegist userAppRegist) {
        try {
            logger.info("Request comming to regist user");
            JsonView view = new JsonView();
            userAppRegist.setRegisttime(new Date());
            userAppRegist.setIdentity(1);
            userAppRegist.setStatus(1);
            UserAppRegist user = userAppRegistService.userLoginOrCheckUserName(userAppRegist.getUsername());
            if (user != null) {
                return JsonView.fail("手机号已注册，请登录");
            }
            userAppRegistService.insertUserAppRegist(userAppRegist);
            view.setData(userAppRegist);
            view.setMessage("注册成功");
            view.setCode(JsonView.SUCCESS);
            return view;
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail("注册失败"+e.getMessage());
        }
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @return
     * @Desription TODO 用户登陆
     */
    @RequestMapping(path = "/userAppLogin", method = RequestMethod.POST)
    public JsonView userAppLogin(String username, String password) {
        try {
            logger.info("Request comming to Login user");
            UserAppRegist user = userAppRegistService.userLoginOrCheckUserName(username);
            if (user == null)
                return JsonView.fail(JsonView.ERROR, "手机号未注册");
            if (!CustomMD5.checkPassword(user.getPassword(), password, username))
                return JsonView.fail(JsonView.ERROR, "密码不正确");
            return JsonView.success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
    }

    /**
     * @param page 分页
     * @return
     * @Desription TODO 查询所有用户注册信息
     */
    @RequestMapping("/all")
    public JsonView findAll(PageRequest page) {
        try {
            logger.info("Request comming to find user list...");
            PageInfo<UserAppRegist> pageInfo = userAppRegistService.findByPage(page);
            return JsonView.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
    }

}
