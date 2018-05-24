package com.ex.controller.core_controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.ex.service.UserService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.service.RedisUtilService;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public JsonView findAll(PageRequest page) {
        logger.info("Request comming to find user list...");
        PageInfo<User> pageInfo = userService.findAll(page);
        return JsonView.success(pageInfo);
    }


        @Reference(version="1.0.0",timeout=100000)
        private RedisUtilService redisUtilService;

        @RequestMapping("/set")
        public String setRedis(String key,String value){
            redisUtilService.set(key,value);
            return "success";
        }

        @RequestMapping("/get")
        public  String  getRedis(String key){
            return redisUtilService.get(key);
        }


}
