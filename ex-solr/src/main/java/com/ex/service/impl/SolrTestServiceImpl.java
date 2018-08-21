package com.ex.service.impl;

import com.ex.service.SolrTestService;

/**
 * @ProjectName ex_parent
 * @ClassName SolrTestServiceImpl
 * @Description dubbo 提供方服务方测试  实现 Produce 暴露接口
 * @Author sanmu
 * @Date 2018/5/28 16:44
 * @Version 1.0
 **/
public class SolrTestServiceImpl implements SolrTestService {

    /* *
     * @author sanmu
     * @Desription dubbo测试
     * @date 2018/5/28 16:45
     * @Param []
     * @return java.lang.String
     **/
    @Override
    public String TestService() {
        return "调用成功===>SolrTestService";
    }
}
