package com.nxu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nxu.entity.User;

public interface UserService extends IService<User> {
    /**
     * 判断手机号码是否被注册
     *
     * @param phone 手机号码
     * @return 是否注册
     */
    boolean isPhoneExist(String phone);

    /**
     * 通过手机号码查询用户(登录)
     *
     * @param phone 手机号码
     * @return 用户实体类
     */
    User getUserByPhone(String phone);
}