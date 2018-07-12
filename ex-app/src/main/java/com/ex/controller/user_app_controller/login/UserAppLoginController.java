package com.ex.controller.user_app_controller.login;

import com.ex.entity.UserAppRegist;
import com.ex.service.UserAppRegistService;
import com.ex.util.CustomMD5;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.util.TokenUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户注册Controller
 */
@RestController
@RequestMapping("/userapp/login")
public class UserAppLoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserAppRegistService userAppRegistService;

    /**
     * 检查用户名是否存在
     *
     * @param username
     * @return
     */
    @RequestMapping("/checkUserName")
    public JsonView checkUserName(String username) {
        JsonView jsonView = new JsonView();
        try {
            logger.info("Request comming to Check username");
            UserAppRegist user = userAppRegistService.userLoginOrCheckUserName(username);
            if (user != null){
                jsonView.setMessage("用户名已存在");
                jsonView.setCode(JsonView.SUCCESS);
            }
            jsonView.setMessage("用户名可用");
            jsonView.setTodoCount(1);
            jsonView.setCode(JsonView.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 用户注册
     *
     * @param userAppRegist
     * @return
     */
    @RequestMapping(path = "/regist", method = RequestMethod.POST)
    public JsonView userAppRegistInsert(UserAppRegist userAppRegist) {
        JsonView jsonView = new JsonView();
        try {
            logger.info("Request comming to regist user");
            userAppRegist.setRegisttime(new Date());
            userAppRegist.setIdentity(1);
            userAppRegist.setStatus(1);
            UserAppRegist user = userAppRegistService.userLoginOrCheckUserName(userAppRegist.getUsername());
            if (user != null) {
                jsonView.setMessage("手机号已注册，请登录!");
                jsonView.setCode(JsonView.SUCCESS);
                return jsonView;
            }
            userAppRegistService.insertUserAppRegist(userAppRegist);
//            view.setData(userAppRegist);
            jsonView.setMessage("注册成功");
            jsonView.setCode(JsonView.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 用户登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(path = "/userAppLogin", method = RequestMethod.POST)
    public JsonView userAppLogin(String username, String password) {
        JsonView jsonView = new JsonView();
        try {
            logger.info("Request comming to Login user");
            UserAppRegist user = userAppRegistService.userLoginOrCheckUserName(username);
            if (user == null){
                jsonView.setMessage("手机号未注册!");
                jsonView.setCode(JsonView.SUCCESS);
                return jsonView;
            }
            if (!CustomMD5.checkPassword(user.getPassword(), password, username)){
                jsonView.setMessage("密码不正确!");
                jsonView.setCode(JsonView.SUCCESS);
                return jsonView;
            }
            //登陆成功获取ToKen
            String token = TokenUtil.UserToken(username, password, user);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("登陆成功!");
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            map.put("user", user);
            jsonView.setData(map);
            jsonView.setTodoCount(1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 查询所有用户注册信息
     *
     * @param page
     * @return
     */
    @RequestMapping("/all")
    public JsonView findAll(PageRequest page) {
        JsonView jsonView = new JsonView();
        try {
            logger.info("Request comming to find user list...");
            PageInfo<UserAppRegist> pageInfo = userAppRegistService.findByPage(page);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求数据成功!");
            jsonView.setTodoCount(pageInfo.getSize());
            jsonView.setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

}
