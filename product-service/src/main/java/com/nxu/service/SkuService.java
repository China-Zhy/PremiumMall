package com.nxu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nxu.entity.Sku;

import java.util.List;

public interface SkuService extends IService<Sku> {

    /**
     * 获取某个商品的全部SKU
     *
     * @param productId 商品ID
     * @return SKU集合
     */
    List<Sku> getSkuListByProductId(Long productId);
}