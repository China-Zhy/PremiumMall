package com.nxu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nxu.entity.Review;
import com.nxu.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 获取某商品的评论数据
    @GetMapping("/getProductReviews/{productId}")
    @ResponseBody
    public Page<Review> getProductReviews(@PathVariable Long productId, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return reviewService.getReviewByProductId(productId, pageNum, pageSize);
    }
}