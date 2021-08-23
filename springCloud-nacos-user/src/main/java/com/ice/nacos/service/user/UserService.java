package com.ice.nacos.service.user;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ice.nacos.model.entity.user.User;
import com.ice.nacos.model.mo.user.LoginMO;
import com.ice.nacos.result.Result;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author lusuyun
 * @since 2021-08-18
 */
public interface UserService extends IService<User> {


    Result<?> getOne(Integer id);

    Result<?> login(LoginMO loginMO);
}
