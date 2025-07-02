package com.nxu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nxu.entity.Review;

public interface ReviewService extends IService<Review> {

    /**
     * 获取某商品的评论信息
     *
     * @param productId 商品ID
     * @param pageNum   当前第几页
     * @param pageSize  每页数据量
     * @return 评论数据集合
     */
    Page<Review> getReviewByProductId(Long productId, Integer pageNum, Integer pageSize);
}