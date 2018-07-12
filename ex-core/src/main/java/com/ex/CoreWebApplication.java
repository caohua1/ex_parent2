package com.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages="com.ex")
@EnableAutoConfiguration
@EnableTransactionManagement(proxyTargetClass = true)
@ImportResource(value = {"classpath:dubbo-consumer.xml"})
public class CoreWebApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(com.ex.CoreWebApplication.class);

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(com.ex.CoreWebApplication.class);
    }

    public static void main(String[] args) {
        logger.info("服务开始运行");
        SpringApplication.run(com.ex.CoreWebApplication.class, args);
    }
    //商户订单号：20187516472458    订单名称：测试     金额：0.01    描述：qqq
}


