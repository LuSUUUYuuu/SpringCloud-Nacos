package com.ice.nacos.service.impl.user;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ice.nacos.mapper.user.UserMapper;
import com.ice.nacos.model.entity.user.User;
import com.ice.nacos.model.mo.user.LoginMO;
import com.ice.nacos.result.Result;
import com.ice.nacos.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

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
        log.info("登录成功");
        return Result.success(byNameAndPwd);
    }
}
