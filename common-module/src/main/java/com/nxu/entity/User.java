package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.UserStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户信息
 */
@Data
@TableName("user")
public class User {
    private long id;                        // 用户ID
    private String name;                    // 用户昵称
    private String phone;                   // 手机号码
    private String email;                   // 电子邮箱
    private String password;                // 账户密码
    private String avatar;                  // 头像链接
    private UserStatus status;              // 用户状态 (0-禁用，1-正常，2-待审核)
    private LocalDateTime lastLoginTime;    // 最后登录时间
    private String lastLoginIp;             // 最后登录IP
}