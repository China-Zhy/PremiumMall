package com.nxu.controller;

import com.nxu.entity.Sku;
import com.nxu.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    // 获取某个商品的SKU数据
    @GetMapping("/getProductSku/{productId}")
    @ResponseBody
    public List<Sku> getProductSku(@PathVariable Long productId) {
        return skuService.getSkuListByProductId(productId);
    }

}