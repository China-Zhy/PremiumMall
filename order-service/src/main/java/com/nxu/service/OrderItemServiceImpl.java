package com.nxu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.OrderItem;
import com.nxu.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}