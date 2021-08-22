package com.ice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName UserApplication
 * @Description //
 * @Author luSuYun
 * @Date 2021/8/22 13:30
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient   //开启服务注册
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
