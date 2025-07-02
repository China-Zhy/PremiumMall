package com.nxu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Cart;
import com.nxu.mapper.CartMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    /**
     * 获取用户的购物车
     *
     * @param userId 用户ID
     * @return 购物车集合
     */
    @Override
    public List<Cart> getCartByUserId(Long userId) {
        return this.list(new QueryWrapper<Cart>().eq("user_id", userId));
    }

    /**
     * 加入购物车
     *
     * @param cart 购物车信息
     * @return 添加结果
     */
    @Override
    public boolean addCart(Cart cart) {
        return this.save(cart);
    }

    /**
     * 修改购物车
     *
     * @param cart 购物车信息
     * @return 修改结果
     */
    @Override
    public boolean updateCart(Cart cart) {
        return this.updateById(cart);
    }

    /**
     * 删除购物车
     *
     * @param cartId 购物车ID
     * @return 删除结果
     */
    @Override
    public boolean deleteCartByCartId(Long cartId) {
        return this.removeById(cartId);
    }
}