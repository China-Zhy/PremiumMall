package com.nxu;

import com.nxu.entity.Product;
import com.nxu.service.ProductService;
import com.nxu.service.SkuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleTest {

    @Autowired
    private SkuService skuService;

    @Autowired
    private ProductService productService;

    @Test
    public void test1() {
        skuService.getSkuListByProductId(1L).forEach(System.out::println);
    }

    @Test
    public void test2() {
        Product byId = productService.getById(1);
        System.out.println(byId);
    }
}