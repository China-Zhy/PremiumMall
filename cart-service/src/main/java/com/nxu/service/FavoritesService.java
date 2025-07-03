package com.nxu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nxu.entity.Favorites;
import com.nxu.entity.Product;

import java.util.List;

public interface FavoritesService extends IService<Favorites> {

    /**
     * 获取用户的收藏
     *
     * @param userId 用户ID
     * @return 收藏的商品集合
     */
    List<Product> getFavoritesByUserId(Long userId);

    /**
     * 添加收藏
     *
     * @param favorites 收藏信息
     * @return 添加结果
     */
    boolean addFavorites(Favorites favorites);

    /**
     * 移除收藏
     *
     * @param favoritesId 收藏ID
     * @return 移除结果
     */
    boolean removeFavorites(Long favoritesId);

    /**
     * 判断某件商品是否被用户收藏
     *
     * @param userId    用户ID
     * @param productId 商品ID
     * @return 是否收藏
     */
    boolean isFavoritesExist(Long userId, Long productId);
}