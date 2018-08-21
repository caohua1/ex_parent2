package com.ex;


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
//@EnableAutoConfiguration 不注释启动会出现找不到数据库dataSource错误
@EnableTransactionManagement(proxyTargetClass = true)
@ImportResource(value = {"classpath:dubbo-privider.xml"})
public class OrderApplication  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(com.ex.OrderApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
