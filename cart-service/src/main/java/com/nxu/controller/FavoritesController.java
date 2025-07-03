package com.nxu.controller;

import com.nxu.entity.Favorites;
import com.nxu.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    // 获取用户的收藏信息
    @GetMapping("/getUserFavoritesHtml/{userId}")
    public String getFavoritesHtml(@PathVariable Long userId, Model model) {
        model.addAttribute("favorites", favoritesService.getFavoritesByUserId(userId));
        return "user-favorites";
    }

    // 添加收藏
    @GetMapping("/addFavorite")
    @ResponseBody
    public boolean addFavorite(@RequestParam Long userId, @RequestParam Long productId) {
        Favorites favorites = new Favorites();
        favorites.setUserId(userId);
        favorites.setProductId(productId);
        return favoritesService.addFavorites(favorites);
    }

    // 取消收藏
    @GetMapping("/delFavorite/{id}")
    @ResponseBody
    public boolean delFavorite(@PathVariable Long id) {
        return favoritesService.removeFavorites(id);
    }

    // 判断某个商品是否被用户收藏
    @GetMapping("/isFavoritesExist")
    @ResponseBody
    public boolean isFavoritesExist(@RequestParam Long userId, @RequestParam Long productId) {
        return favoritesService.isFavoritesExist(userId, productId);
    }

}