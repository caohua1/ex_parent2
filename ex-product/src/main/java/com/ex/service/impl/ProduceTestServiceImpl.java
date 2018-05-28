package com.ex.service.impl;

import com.ex.service.ProduceTestService;

/**
 * @ProjectName ex_parent
 * @ClassName ProduceTestServiceImpl
 * @Description dubbo 提供方服务方测试  实现 Produce 暴露接口
 * @Author sanmu
 * @Date 2018/5/28 16:16
 * @Version 1.0
 **/
public class ProduceTestServiceImpl implements ProduceTestService {

    /* *
     * @author sanmu
     * @Desription dubbo测试
     * @date 2018/5/28 16:19
     * @Param []
     * @return java.lang.String
     **/
    @Override
    public String TestService() {
        return "调用成功===>ProduceTestService";
    }
}
