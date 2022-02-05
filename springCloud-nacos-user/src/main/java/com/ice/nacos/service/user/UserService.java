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


    /** 
    * @Description: 根据用户ID查询用户 
    * @Param:  
    * @return:  
    * @Author: LuuuuSuYunnn
    * @Date: 2022/2/6 
    */ 
    Result<?> getOne(Integer id);

    /** 
    * @Description: 用户登录 
    * @Param:  
    * @return:  
    * @Author: LuuuuSuYunnn
    * @Date: 2022/2/6 
    */ 
    Result<?> login(LoginMO loginMO);

    
    /** 
    * @Description: 注册用户 
    * @Param:  
    * @return:  
    * @Author: LuuuuSuYunnn
    * @Date: 2022/2/6 
    */ 
    Result<?> register(LoginMO loginMO);
    
}
