package com.nxu.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service")
public interface OrderApi {
    // 订单详情信息(未完待续)
    @GetMapping("/order/getOrderDetailHtml/{id}")
    String getOrderDetailHtml(@PathVariable Long id, Model model);
}