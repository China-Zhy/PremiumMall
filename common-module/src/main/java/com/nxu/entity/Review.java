package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.ReviewStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 商品评论信息
 */
@Data
@TableName("review")
public class Review {
    private long id;                        // 评论ID
    private long userId;                    // 用户ID
    private long productId;                 // 商品ID
    private long orderId;                   // 订单ID
    private String content;                 // 评论内容
    private String images;                  // 评论图片
    private int score;                      // 评分 (1-5)
    private ReviewStatus status;            // 评论状态 (0-隐藏，1-显示)
    private LocalDateTime sendTime;         // 评论时间
}