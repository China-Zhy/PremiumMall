package com.nxu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.apis.ProductApi;
import com.nxu.entity.Favorites;
import com.nxu.entity.Product;
import com.nxu.mapper.FavoritesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites> implements FavoritesService {

    @Autowired
    private ProductApi productApi;

    /**
     * 获取用户的收藏
     *
     * @param userId 用户ID
     * @return 收藏集合
     */
    @Override
    public List<Product> getFavoritesByUserId(Long userId) {
        List<Favorites> favorites = this.list(new QueryWrapper<Favorites>().eq("user_id", userId));
        List<Product> products = new ArrayList<>();
        for (Favorites favorite : favorites) {
            Product oneProduct = productApi.getOneProduct(favorite.getProductId());
            oneProduct.setStock(favorite.getId());      // 把收藏ID存入商品库存(后续需要优化)
            products.add(oneProduct);
        }
        return products;
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
    public boolean removeFavorites(Long favoritesId) {
        return this.removeById(favoritesId);
    }

    /**
     * 判断某件商品是否被用户收藏
     *
     * @param userId    用户ID
     * @param productId 商品ID
     * @return 是否收藏
     */
    @Override
    public boolean isFavoritesExist(Long userId, Long productId) {
        Favorites one = this.getOne(new QueryWrapper<Favorites>().eq("user_id", userId).eq("product_id", productId));
        return one != null;
    }
}