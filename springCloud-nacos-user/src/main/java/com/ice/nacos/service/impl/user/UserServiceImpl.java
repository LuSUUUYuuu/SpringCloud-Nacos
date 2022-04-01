package com.ice.nacos.service.impl.user;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ice.nacos.mapper.user.UserMapper;
import com.ice.nacos.model.entity.user.User;
import com.ice.nacos.model.mo.user.LoginMO;
import com.ice.nacos.result.ClientUser;
import com.ice.nacos.result.Result;
import com.ice.nacos.service.user.UserService;
import com.ice.nacos.utils.JwtUtil;
import com.ice.nacos.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author lusuyun
 * @since 2021-08-18
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public Result<?> getOne(Integer id) {
        log.info("查询用户");
        User byId = userMapper.getById(id);
        if (ObjectUtils.isEmpty(byId)){
            return Result.failure("未查到用户信息");
        }
        return Result.success(byId);
        //return new User();
    }

    @Override
    public Result<?> login(LoginMO loginMO) {
        log.info("用户登录");
        User byNameAndPwd = userMapper.getByNameAndPwd(loginMO);
        if (ObjectUtils.isEmpty(byNameAndPwd)){
            return Result.failure("用户名或密码错误");
        }

        ClientUser clientUser = new ClientUser();
        BeanUtil.copyProperties(loginMO, clientUser, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));

        //生成JWT token
        log.info("生成JWT token");
        String jsonString = JSON.toJSONString(clientUser);

        String generateToken = JwtUtil.generateToken(jsonString);

        redisUtil.set("JWT token:" + clientUser.getId(), generateToken, 60 * 60 * 24);

        HashMap<String, Object> loginUserMap = new HashMap<>();
        loginUserMap.put("userInfo", clientUser);
        loginUserMap.put("userToken", generateToken);


        log.info("登录成功");
        return Result.success(loginUserMap);
    }

    @Transactional
    @Override
    public Result<?> register(LoginMO loginMO) {
        log.info("用户注册");
        Boolean aBoolean = userMapper.checkUserNameRepeat(loginMO.getUserName());
        if (aBoolean){
            return Result.failure("用户名已存在，请重新注册");
        }
        User user = new User();
        user.setUserName(loginMO.getUserName()).setPassword(loginMO.getPassword());
        this.save(user);
        return Result.success();
    }



}
