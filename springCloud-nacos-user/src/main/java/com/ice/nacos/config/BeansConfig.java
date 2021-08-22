package com.ice.nacos.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName BeansConfig
 * @Description //
 * @Author luSuYun
 * @Date 2021/8/22 16:18
 * @Version 1.0
 **/
@Configuration
public class BeansConfig {

    @Bean
    @LoadBalanced  //负载均衡客户端
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
