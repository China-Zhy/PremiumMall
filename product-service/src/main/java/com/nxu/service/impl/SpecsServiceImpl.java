package com.nxu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Specs;
import com.nxu.mapper.SpecsMapper;
import com.nxu.service.SpecsService;
import org.springframework.stereotype.Service;

@Service
public class SpecsServiceImpl extends ServiceImpl<SpecsMapper, Specs> implements SpecsService {

}