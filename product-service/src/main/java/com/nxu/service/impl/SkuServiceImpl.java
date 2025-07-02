package com.nxu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Sku;
import com.nxu.mapper.SkuMapper;
import com.nxu.service.SkuService;
import org.springframework.stereotype.Service;

@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

}