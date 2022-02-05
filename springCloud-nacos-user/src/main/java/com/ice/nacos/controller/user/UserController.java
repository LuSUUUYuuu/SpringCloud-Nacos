package com.ice.nacos.controller.user;
import java.time.LocalDateTime;

import com.ice.nacos.client.GoodsClient;
import com.ice.nacos.model.entity.user.User;
import com.ice.nacos.model.mo.user.LoginMO;
import com.ice.nacos.result.Result;
import com.ice.nacos.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName UserController
 * @Description //
 * @Author luSuYun
 * @Date 2021/8/22 15:01
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private UserService userService;




    /** 
    * @Description: 获取用户信息 
    * @Param:  
    * @return:  
    * @Author: LuuuuSuYunnn
    * @Date: 2022/2/6 
    */ 
    @GetMapping("/getById")
    public Result getUser(@RequestParam("id") Integer id){
        return userService.getOne(id);
    }

    /** 
    * @Description: 用户登录 
    * @Param:  
    * @return:  
    * @Author: LuuuuSuYunnn
    * @Date: 2022/2/6 
    */ 
    @PostMapping("/login")
    public Result login(@RequestBody LoginMO loginMO){
        return userService.login(loginMO);
    }

    
    /** 
    * @Description: 用户注册 
    * @Param:  
    * @return:  
    * @Author: LuuuuSuYunnn
    * @Date: 2022/2/6 
    */ 
    @PostMapping("/register")
    public Result register(@RequestBody LoginMO loginMO){
        return userService.register(loginMO);
    }


}
