package com.nxu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nxu.entity.Favorites;

import java.util.List;

public interface FavoritesService extends IService<Favorites> {

    /**
     * 获取用户的收藏
     *
     * @param userId 用户ID
     * @return 收藏集合
     */
    List<Favorites> getFavoritesByUserId(Long userId);

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
    boolean removeFavorites(long favoritesId);
}