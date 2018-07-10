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
public class AppApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(com.ex.AppApplication.class);

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(com.ex.AppApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
