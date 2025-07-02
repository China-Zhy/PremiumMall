package com.nxu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Image;
import com.nxu.mapper.ImageMapper;
import com.nxu.service.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

}