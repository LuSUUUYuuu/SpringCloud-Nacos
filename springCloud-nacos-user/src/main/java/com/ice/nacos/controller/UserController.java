package com.ice.nacos.controller;

import com.google.errorprone.annotations.Var;
import com.ice.nacos.client.GoodsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    private DiscoveryClient discoveryClient; //服务发现客户端

    @Autowired
    private LoadBalancerClient loadBalancerClient;  //负载均衡客户端组件

    @Autowired
    private RestTemplate restTemplate;  //这个对象才是具有负载均衡的restTemple

    @Autowired
    private GoodsClient goodsClient;


    //推荐http rest方式通信： 1.restTemplate  缺点: (1) 无法实现请求负载均衡  (2)路径写死在代码中不利于后续维护

    @GetMapping("/invoke")
    public String invokeUserService(){
        LOGGER.info("调用用户服务");
        return "调用用户服务";
    }


    @GetMapping("/restTemplateInvokeGoods")
    public String restTemplateInvokeGoodsService(){
        LOGGER.info("用户服务调用商品服务");
        //调用商品服务
        String forObject = new RestTemplate().getForObject("http://localhost:9090/goods/invoke?id=1", String.class);
        return forObject;
    }

    @GetMapping("/ribbonInvokeGoods")
    public String ribbonInvokeGoodsService(){
        LOGGER.info("用户服务调用商品服务");
        //调用商品服务
        //使用ribbon组件实现负载均衡 1.引入ribbon依赖(nacos client 存在这个依赖)  2.使用ribbon 完成负载均衡 DiscoveryClient  LoadBalanceClient  @LoadBalance
        /*1.discoveryClient方式使用ribbon组件实现负载均衡*/
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("NACOS-GOODS");
//        for (ServiceInstance serviceInstance : serviceInstances) {
//            LOGGER.info("服务主机:{} 服务端口:{} 服务URL:{}", serviceInstance.getHost(), serviceInstance.getPort(), serviceInstance.getUri());
//        }
        /*这里需要手写负载均衡策略*/
//        String result = new RestTemplate().getForObject(serviceInstances.get(0).getUri() + "/goods/invoke?id=1", String.class);

        /*2.loadBalanceClient方式使用ribbon组件实现负载均衡*/
//        ServiceInstance serviceInstance = loadBalancerClient.choose("NACOS-GOODS"); //已经进行负载均衡之后返回节点(默认轮询)
//        String result = new RestTemplate().getForObject(serviceInstance.getUri() + "/goods/invoke?id=1", String.class);

        /*3.@LoadBalance注解方式使用ribbon组件实现负载均衡*/
        String result = restTemplate.getForObject("http://NACOS-GOODS/goods/invoke?id=1", String.class);
        LOGGER.info("用户服务调用结果:{}", result);
        return result;
    }

    @GetMapping("/openFeignInvokeGoods")
    public String openFeignInvokeGoodsService(){
        LOGGER.info("用户服务调用商品服务");
        //调用商品服务
        String result = goodsClient.goods(21);
        return result;
    }
}
