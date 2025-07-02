package com.nxu.apis;

import com.nxu.entity.Product;
import com.nxu.model.ProductSelect;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductApi {

    // 商城首页
    @GetMapping("/product/index")
    String index(Model model);

    // 条件查询商品
    @PostMapping("/product/productSelect")
    @ResponseBody
    List<Product> productSelect(@RequestBody ProductSelect product);

    // 商品详情信息
    @GetMapping("/product/productDetail/{id}")
    String productDetail(@PathVariable Long id, Model model);
}