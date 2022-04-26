package com.ice.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DiscoverController
 * @Description //
 * @Author luSuYun
 * @Date 2021/8/22 16:52
 * @Version 1.0
 **/
@RestController
@RequestMapping("/discover")
public class DiscoverController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscoverController.class);

    @Value("${server.port}")
    private Integer port;

    @GetMapping()
    public String discover(){
        LOGGER.info("检测服务,端口: {}", port);



        return "User service OK";
    }
}
