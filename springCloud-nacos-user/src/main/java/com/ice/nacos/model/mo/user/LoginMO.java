package com.ice.nacos.model.mo.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName LoginMO
 * @Description //
 * @Author luSuYun
 * @Date 2021/8/22 21:15
 * @Version 1.0
 **/
@Data
public class LoginMO implements Serializable {

    private String userName;

    private String password;

}
