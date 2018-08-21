package com.ex.service.impl;

import com.ex.service.OrderTestService;

/**
 * @ProjectName ex_parent
 * @ClassName OrderTestServiceImpl
 * @Description dubbo 提供方服务方测试  提供 Order 暴露接口实现
 * @Author sanmu
 * @Date 2018/5/28 17:18
 * @Version 1.0
 **/
public class OrderTestServiceImpl implements OrderTestService {

    /* *
     * @author sanmu
     * @Desription dubbo 测试
     * @date 2018/5/28 17:20
     * @Param []
     * @return java.lang.String
     **/
    @Override
    public String TestService() {
        return "调用成功===>OrderTestServiceImpl";
    }
}
