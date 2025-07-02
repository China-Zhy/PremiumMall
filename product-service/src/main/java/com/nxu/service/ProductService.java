package com.nxu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nxu.entity.Product;
import com.nxu.model.ProductDetails;
import com.nxu.model.ProductSelect;

public interface ProductService extends IService<Product> {

    /**
     * 按条件搜索商品
     *
     * @param data 搜索条件
     * @return 商品数据集合
     */
    Page<Product> selectProduct(ProductSelect data);

    /**
     * 获取商品详情信息
     *
     * @param id 商品ID
     * @return 商品详情信息
     */
    ProductDetails getProductDetail(Long id);
}