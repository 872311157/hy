package com.example.hy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.example.hy.*.mapper") //扫描的mapper
@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})//该注解的作用是，排除自动注入数据源的配置（取消数据库配置,使用时无法自动注入EntityBean，和SSM使用报错），一般使用在客户端（消费者）服务中
public class HyApplication {
    public static void main(String[] args) {
        SpringApplication.run(HyApplication.class, args);
    }
}
