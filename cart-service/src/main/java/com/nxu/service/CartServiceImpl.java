package com.nxu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.apis.ProductApi;
import com.nxu.entity.Cart;
import com.nxu.entity.Product;
import com.nxu.entity.Sku;
import com.nxu.mapper.CartMapper;
import com.nxu.model.CartDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    private ProductApi productApi;

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
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        if (cart.getId() > 0) {
            queryWrapper.eq("id", cart.getId());
        }
        if (cart.getSkuId() > 0) {
            queryWrapper.eq("sku_id", cart.getSkuId());
        }
        if (cart.getQuantity() > 0) {
            queryWrapper.eq("quantity", cart.getQuantity());
        }
        if (cart.getSelected() != null) {
            queryWrapper.eq("selected", cart.getSelected());
        }
        return this.update(queryWrapper);
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

    /**
     * 获取用户购物车详情信息
     *
     * @param userId 用户ID
     * @return 购物车详情信息
     */
    @Override
    public List<CartDetail> getUserCartDetail(Long userId) {
        ArrayList<CartDetail> list = new ArrayList<>();
        List<Cart> carts = this.getCartByUserId(userId);
        for (Cart cart : carts) {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCart(cart);

            Product oneProduct = productApi.getOneProduct(cart.getProductId());
            cartDetail.setProduct(oneProduct);

            List<Sku> skus = productApi.getProductSku(oneProduct.getId());
            cartDetail.setSkuList(skus);

            list.add(cartDetail);   // 把每个商品的详情信息加入集合
        }
        return list;
    }

    /**
     * 商品是否在购物车中
     *
     * @param userId    用户ID
     * @param productId 商品ID
     * @return 是否存在购物车中
     */
    @Override
    public boolean isCartExist(Long userId, Long productId) {
        Cart one = this.getOne(Wrappers.<Cart>lambdaQuery().eq(Cart::getUserId, userId).eq(Cart::getProductId, productId));
        return one != null;
    }
}