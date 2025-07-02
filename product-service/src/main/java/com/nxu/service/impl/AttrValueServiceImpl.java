package com.nxu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.AttrValue;
import com.nxu.mapper.AttrValueMapper;
import com.nxu.service.AttrValueService;
import org.springframework.stereotype.Service;

@Service
public class AttrValueServiceImpl extends ServiceImpl<AttrValueMapper, AttrValue> implements AttrValueService {

}