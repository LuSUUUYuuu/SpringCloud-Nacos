package com.ice.nacos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName GoodsClient
 * @Description //
 * @Author luSuYun
 * @Date 2021/8/22 16:31
 * @Version 1.0
 **/

@FeignClient("NACOS-GOODS")
public interface GoodsClient {

    @GetMapping("/goods/invoke")
    String goods(@RequestParam("id") Integer id);

}
