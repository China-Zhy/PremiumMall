package com.nxu.controller;

import com.nxu.entity.Cart;
import com.nxu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // 获取用户购物车页面
    @GetMapping("/toUserCartHtml/{userId}")
    public String toUserCartHtml(@PathVariable Long userId, Model model) {
        model.addAttribute("cartDetail", cartService.getUserCartDetail(userId));
        return "user-cart";
    }

    // 添加购物车
    @PostMapping("/addCart")
    @ResponseBody
    public boolean addCart(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }

    // 删除购物车
    @GetMapping("/delCart/{id}")
    @ResponseBody
    public boolean delCart(@PathVariable Long id) {
        return cartService.deleteCartByCartId(id);
    }

    // 更新购物车
    @PostMapping("/updateCart")
    @ResponseBody
    public boolean updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    // 判断某商品是否在用户的购物车中
    @GetMapping("/isCartExist")
    @ResponseBody
    public boolean isCartExist(@RequestParam Long userId, @RequestParam Long productId) {
        return cartService.isCartExist(userId, productId);
    }

}