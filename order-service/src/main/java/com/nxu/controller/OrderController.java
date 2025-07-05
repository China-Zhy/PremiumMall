package com.nxu.controller;

import com.nxu.service.OrderItemService;
import com.nxu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    // 订单详情信息(未完待续)
    @GetMapping("/getOrderDetailHtml/{id}")
    public String getOrderDetailHtml(@PathVariable Long id, Model model) {
        return "order-detail";
    }
}