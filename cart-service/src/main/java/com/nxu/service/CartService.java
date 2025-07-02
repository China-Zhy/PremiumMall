package com.nxu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nxu.entity.Cart;

import java.util.List;

public interface CartService extends IService<Cart> {

    /**
     * 获取用户的购物车
     *
     * @param userId 用户ID
     * @return 购物车集合
     */
    List<Cart> getCartByUserId(Long userId);

    /**
     * 加入购物车
     *
     * @param cart 购物车信息
     * @return 添加结果
     */
    boolean addCart(Cart cart);

    /**
     * 修改购物车
     *
     * @param cart 购物车信息
     * @return 修改结果
     */
    boolean updateCart(Cart cart);

    /**
     * 删除购物车
     *
     * @param cartId 购物车ID
     * @return 删除结果
     */
    boolean deleteCartByCartId(Long cartId);
}