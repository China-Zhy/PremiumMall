package com.nxu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.User;
import com.nxu.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * 判断手机号码是否被注册
     *
     * @param phone 手机号码
     * @return 是否注册
     */
    @Override
    public boolean isPhoneExist(String phone) {
        long count = this.count(new QueryWrapper<User>().eq("phone", phone));
        return count > 0;
    }

    /**
     * 通过手机号码查询用户(登录)
     *
     * @param phone 手机号码
     * @return 用户实体类
     */
    @Override
    public User getUserByPhone(String phone) {
        return this.getOne(new QueryWrapper<User>().eq("phone", phone));
    }
}