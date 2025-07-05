package com.nxu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Address;
import com.nxu.mapper.AddressMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    /**
     * 获取用户的收货地址
     *
     * @param userId 用户ID
     * @return 收货地址集合
     */
    @Override
    public List<Address> getAddressByUserId(Long userId) {
        return this.list(new QueryWrapper<Address>().eq("user_id", userId));
    }
}