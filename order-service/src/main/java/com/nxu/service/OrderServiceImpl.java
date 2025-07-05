package com.nxu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Order;
import com.nxu.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}