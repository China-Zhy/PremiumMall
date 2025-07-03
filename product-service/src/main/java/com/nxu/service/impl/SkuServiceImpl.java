package com.nxu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Sku;
import com.nxu.mapper.SkuMapper;
import com.nxu.service.SkuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    /**
     * 获取某个商品的全部SKU
     *
     * @param productId 商品ID
     * @return SKU集合
     */
    @Override
    public List<Sku> getSkuListByProductId(Long productId) {
        return this.list(new QueryWrapper<Sku>().eq("product_id", productId));
    }
}