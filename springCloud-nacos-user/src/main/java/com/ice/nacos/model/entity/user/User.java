package com.ice.nacos.model.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author lusuyun
 * @since 2021-08-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业id
     */
    @TableField("enterprise_id")
    private Integer enterpriseId;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField("mail")
    private String mail;

    /**
     * 是否删除
     */
    @TableField("is_del")
    private Boolean isDel;

    /**
     * 登陆时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("login_time")
    private LocalDateTime loginTime;

    /**
     * 头像地址
     */
    @TableField("img")
    private String img;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 男女 0: 没填 1: 男, 2: 女
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 省
     */
    @TableField("province")
    private String province;

    /**
     * 市
     */
    @TableField("city")
    private String city;

    /**
     * 区
     */
    @TableField("area")
    private String area;

    /**
     * 国家
     */
    @TableField("country")
    private String country;

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("register_time")
    private LocalDateTime registerTime;

    /**
     * 注册ip
     */
    @TableField("register_ip")
    private String registerIp;

    /**
     * 登陆ip
     */
    @TableField("login_ip")
    private String loginIp;

    /**
     * 生日
     */
    @TableField("birthday")
    private String birthday;

    /**
     * 创建时间 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 时间戳
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("modify_time")
    private LocalDateTime modifyTime;

    /**
     * 修改人
     */
    @TableField("modify_user")
    private String modifyUser;

    /**
     * 是否拉黑 0: 不拉黑 1: 拉黑
     */
    @TableField("is_pull_black")
    private Boolean isPullBlack;

    /**
     * 拉黑时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("pull_black_time")
    private LocalDateTime pullBlackTime;


}
