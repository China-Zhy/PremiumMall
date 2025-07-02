package com.nxu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Review;
import com.nxu.mapper.ReviewMapper;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {

    /**
     * 获取某商品的评论信息
     *
     * @param productId 商品ID
     * @param pageNum   当前第几页
     * @param pageSize  每页数据量
     * @return 评论数据集合
     */
    @Override
    public Page<Review> getReviewByProductId(Long productId, Integer pageNum, Integer pageSize) {
        QueryWrapper<Review> queryWrapper = new QueryWrapper<>();
        if (productId != null && productId != 0) {
            queryWrapper.eq("product_id", productId);
        }
        // 创建分页对象，pageNum为当前页码，pageSize为每页条数
        Page<Review> page = new Page<>(pageNum, pageSize);
        return page(page, queryWrapper);
    }
}