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
public class UserAppLoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserAppRegistService userAppRegistService;

    /**
     * @param username
     * @return
     * @Desription 检查用户名是否存在
     */
    @RequestMapping("/checkUserName")
    public JsonView checkUserName(String username) {
        try {
            logger.info("Request comming to Check username");
            UserAppRegist user = userAppRegistService.checkUserName(username);
            if (user != null)
                return JsonView.fail(JsonView.ERROR, "用户名已存在");
            return JsonView.success("用户名可用");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
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
        try {
            logger.info("Request comming to regist user");
            JsonView view = new JsonView();
            UserAppRegist user = userAppRegistService.checkUserName(userAppRegist.getUsername());
            if (user != null) {
                return JsonView.fail(JsonView.ERROR, "用户名已存在");
            }
            userAppRegistService.insertUserAppRegist(userAppRegist);
            return JsonView.success("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @return
     * @Desription 用户登陆
     */
    @RequestMapping(path = "/userAppLogin", method = RequestMethod.POST)
    public JsonView userAppLogin(String username, String password) {
        try {
            logger.info("Request comming to Login user");
            UserAppRegist user = userAppRegistService.checkUserName(username);
            if (user == null)
                return JsonView.fail(JsonView.ERROR, "用户名已存在");
            if (!userAppRegistService.checkPassword(user.getPassword(), password, username))
                return JsonView.fail(JsonView.ERROR, "密码不正确");
            return JsonView.success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR, e.getMessage());
        }
    }

    /**
     * @Desription 查询所有用户信息
     * @param page 分页
     * @return
     */
    @RequestMapping("/all")
    public JsonView findAll(PageRequest page) {
        try{
        logger.info("Request comming to find user list...");
        PageInfo<UserAppRegist> pageInfo = userAppRegistService.findByPage(page);
        return JsonView.success(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return JsonView.fail(JsonView.ERROR,e.getMessage());
        }
    }

}
