package com.ice.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.Port;

/**
 * @ClassName GoodsController
 * @Description //
 * @Author luSuYun
 * @Date 2021/8/22 14:56
 * @Version 1.0
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/invoke")
    public String invokeGoodsService(Integer id){
        LOGGER.info("调用商品服务id:{}", id);
        return "调用商品服务返回：" + id + ",提供服务的端口为" + port;
    }
}
