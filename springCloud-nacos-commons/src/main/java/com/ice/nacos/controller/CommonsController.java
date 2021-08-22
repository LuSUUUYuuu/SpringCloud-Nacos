package com.ice.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CommonsController
 * @Description //
 * @Author luSuYun
 * @Date 2021/8/22 17:02
 * @Version 1.0
 **/
@RestController
@RequestMapping("/commons")
public class CommonsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonsController.class);

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/invoke")
    public String invokeCommonsService(Integer id){
        LOGGER.info("调用通用服务id:{}", id);
        return "调用通用服务返回：" + id + ",提供服务的端口为" + port;
    }
}
