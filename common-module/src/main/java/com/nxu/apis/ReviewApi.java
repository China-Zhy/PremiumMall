package com.nxu.apis;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nxu.entity.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "review-service")
public interface ReviewApi {

    // 获取某商品的评论数据
    @GetMapping("/review/getProductReviews/{productId}")
    @ResponseBody
    Page<Review> getProductReviews(@PathVariable Long productId, @RequestParam Integer pageNum, @RequestParam Integer pageSize);
}