package com.nxu.model;

import com.nxu.entity.*;
import lombok.Data;

import java.util.List;

/**
 * 商品详情信息
 */
@Data
public class ProductDetails {
    private Product product;                // 商品信息
    private Brand brand;                    // 品牌信息
    private List<Specs> specs;              // 规格信息
    private List<Sku> skus;                 // SKU信息
    private List<Image> images;             // 图片信息
    private List<Review> reviews;           // 评价信息
}