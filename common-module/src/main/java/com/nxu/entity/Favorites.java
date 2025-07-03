package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 我的收藏信息
 */
@Data
@TableName("favorites")
public class Favorites {
    private long id;                        // 收藏ID
    private long userId;                    // 用户ID
    private long productId;                 // 商品ID
}