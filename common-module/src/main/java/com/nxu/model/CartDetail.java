package com.nxu.model;

import com.nxu.entity.Cart;
import com.nxu.entity.Product;
import com.nxu.entity.Sku;
import lombok.Data;

import java.util.List;

/**
 * 购物车信息
 */
@Data
public class CartDetail {
    private Product product;                // 商品信息
    private List<Sku> skuList;              // SKU信息
    private Cart cart;                      // 购物车信息
}