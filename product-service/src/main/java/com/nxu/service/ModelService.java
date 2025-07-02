package com.nxu.service;

import com.nxu.model.ProductSearch;

import java.util.List;

public interface ModelService {

    /**
     * 获取商品搜索条件
     *
     * @return 商品搜索条件模型
     */
    List<ProductSearch> getProductSearch();
}