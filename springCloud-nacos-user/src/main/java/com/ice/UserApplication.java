package com.ice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName UserApplication
 * @Description //
 * @Author luSuYun
 * @Date 2021/8/22 13:30
 * @Version 1.0
 **/
@SpringBootApplication
@EnableFeignClients  //开启openfeign调用支持
@EnableDiscoveryClient   //开启服务注册
@MapperScan("com.ice.nacos.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
