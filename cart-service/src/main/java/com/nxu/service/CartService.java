package com.nxu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nxu.entity.Cart;
import com.nxu.model.CartDetail;

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

    /**
     * 获取用户购物车详情信息
     *
     * @param userId 用户ID
     * @return 购物车详情信息
     */
    List<CartDetail> getUserCartDetail(Long userId);

    /**
     * 商品是否在购物车中
     *
     * @param userId    用户ID
     * @param productId 商品ID
     * @return 是否存在购物车中
     */
    boolean isCartExist(Long userId, Long productId);
}