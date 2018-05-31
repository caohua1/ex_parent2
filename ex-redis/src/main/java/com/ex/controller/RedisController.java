package com.ex.controller;

import com.ex.service.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/set")
    public String setRedis(String key,String value){
        redisUtil.set(key,value);
        return "success";
    }

    @RequestMapping("/get")
    public  String  getRedis(String key){
        return redisUtil.get(key);
    }
}
