package com.example.hy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//该注解的作用是，排除自动注入数据源的配置（取消数据库配置），一般使用在客户端（消费者）服务中
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HyApplication.class, args);
    }

}
