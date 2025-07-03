package com.nxu.controller;

import com.nxu.entity.Product;
import com.nxu.model.ProductSelect;
import com.nxu.service.ModelService;
import com.nxu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ModelService modelService;

    @Autowired
    private ProductService productService;

    // 商城首页
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("searchData", modelService.getProductSearch());
        return "product-index";
    }

    // 条件查询商品
    @PostMapping("/productSelect")
    @ResponseBody
    public List<Product> productSelect(@RequestBody ProductSelect product) {
        return productService.selectProduct(product).getRecords();
    }

    // 商品详情信息
    @GetMapping("/productDetail/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        model.addAttribute("detail", productService.getProductDetail(id));
        return "product-detail";
    }

    // 某个商品的信息
    @GetMapping("/someoneProduct/{id}")
    @ResponseBody
    public Product getOneProduct(@PathVariable Long id) {
        return productService.getById(id);
    }
}