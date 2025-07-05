package com.nxu;

import com.nxu.model.CartDetail;
import com.nxu.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SimpleTest {

    @Autowired
    private CartService cartService;

    @Test
    public void test() {
        List<CartDetail> userCartDetail = cartService.getUserCartDetail(1L);
        userCartDetail.forEach(System.out::println);
    }


}