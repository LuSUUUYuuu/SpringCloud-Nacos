package com.ice.nacos.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/es")
@Slf4j
public class EsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsController.class);

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/invoke")
    public String invokeGoodsService(Integer id){
        LOGGER.info("调用ES服务id:{}", id);
        return "调用E服务返回：" + id + ",提供服务的端口为" + port;
    }

}
