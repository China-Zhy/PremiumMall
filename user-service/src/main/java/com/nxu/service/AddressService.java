package com.nxu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nxu.entity.Address;

import java.util.List;

public interface AddressService extends IService<Address> {

    /**
     * 获取用户的收货地址
     *
     * @param userId 用户ID
     * @return 收货地址集合
     */
    List<Address> getAddressByUserId(Long userId);
}