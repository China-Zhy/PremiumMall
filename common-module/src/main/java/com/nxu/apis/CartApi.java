package com.nxu.apis;

import com.nxu.entity.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cart-service")
public interface CartApi {

    // ---Cart的API---------------------------------------------------------------------------------------

    // 获取用户购物车页面
    @GetMapping("/cart/toUserCartHtml/{userId}")
    String toUserCartHtml(@PathVariable Long userId, Model model);

    // 添加购物车
    @PostMapping("/cart/addCart")
    @ResponseBody
    boolean addCart(@RequestBody Cart cart);

    // 删除购物车
    @GetMapping("/cart/delCart/{id}")
    @ResponseBody
    boolean delCart(@PathVariable Long id);

    // 更新购物车
    @PostMapping("/cart/updateCart")
    @ResponseBody
    boolean updateCart(@RequestBody Cart cart);

    // 判断某商品是否在用户的购物车中
    @GetMapping("/cart/isCartExist")
    @ResponseBody
    boolean isCartExist(@RequestParam Long userId, @RequestParam Long productId);

    // ---Product的API---------------------------------------------------------------------------------------

    // 获取用户的收藏信息
    @GetMapping("/favorites/getUserFavoritesHtml/{userId}")
    String getFavoritesHtml(@PathVariable Long userId, Model model);

    // 添加收藏
    @GetMapping("/favorites/addFavorite")
    @ResponseBody
    boolean addFavorite(@RequestParam Long userId, @RequestParam Long productId);

    // 取消收藏
    @GetMapping("/favorites/delFavorite/{id}")
    @ResponseBody
    boolean delFavorite(@PathVariable Long id);

    // 判断某个商品是否被用户收藏
    @GetMapping("/favorites/isFavoritesExist")
    @ResponseBody
    boolean isFavoritesExist(@RequestParam Long userId, @RequestParam Long productId);

}