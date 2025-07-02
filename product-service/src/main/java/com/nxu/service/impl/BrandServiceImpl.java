package com.nxu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Brand;
import com.nxu.mapper.BrandMapper;
import com.nxu.service.BrandService;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

}