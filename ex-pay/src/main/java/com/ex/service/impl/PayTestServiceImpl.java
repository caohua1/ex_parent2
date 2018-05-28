package com.ex.service.impl;

import com.ex.service.PayTestService;

/**
 * @ProjectName ex_parent
 * @ClassName PayTestServiceImpl
 * @Description dubbo 提供方服务方测试  提供 Pay 暴露接口实现
 * @Author sanmu
 * @Date 2018/5/28 16:33
 * @Version 1.0
 **/
public class PayTestServiceImpl implements PayTestService {

    /* *
     * @author sanmu
     * @Desription dubbo 测试
     * @date 2018/5/28 16:34
     * @Param []
     * @return java.lang.String
     **/
    @Override
    public String TestService() {
        return "调用成功===>PayTestServiceImpl";
    }
}
