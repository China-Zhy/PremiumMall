package com.nxu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Favorites;
import com.nxu.mapper.FavoritesMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites> implements FavoritesService {

    /**
     * 获取用户的收藏
     *
     * @param userId 用户ID
     * @return 收藏集合
     */
    @Override
    public List<Favorites> getFavoritesByUserId(Long userId) {
        return this.list(new QueryWrapper<Favorites>().eq("user_id", userId));
    }

    /**
     * 添加收藏
     *
     * @param favorites 收藏信息
     * @return 添加结果
     */
    @Override
    public boolean addFavorites(Favorites favorites) {
        return this.save(favorites);
    }

    /**
     * 移除收藏
     *
     * @param favoritesId 收藏ID
     * @return 移除结果
     */
    @Override
    public boolean removeFavorites(long favoritesId) {
        return this.removeById(favoritesId);
    }
}