package com.ice.nacos.mapper.user;

import com.ice.nacos.model.entity.user.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ice.nacos.model.mo.user.LoginMO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author lusuyun
 * @since 2021-08-18
 */
@Service
public interface UserMapper extends BaseMapper<User> {


    User getById(@Param("id") Integer id);

    User getByNameAndPwd(@Param("loginMO")LoginMO loginMO);

    Boolean checkUserNameRepeat(@Param("userName") String userName);
}
