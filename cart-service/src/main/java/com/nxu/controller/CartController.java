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
        model.addAttribute("cartList", cartService.getCartByUserId(userId));
        return "user-cart";
    }

    // 添加购物车
    @PostMapping("/addCart")
    @ResponseBody
    public boolean addCart(@RequestBody Cart cart) {
        System.out.println("购物车信息：" + cart);
        return cartService.addCart(cart);
    }

}