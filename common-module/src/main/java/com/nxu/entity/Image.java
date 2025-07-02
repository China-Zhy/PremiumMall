package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.ImageType;
import lombok.Data;

/**
 * 商品图片信息
 */
@Data
@TableName("image")
public class Image {
    private long id;                        // 图片ID
    private long productId;                 // 商品ID
    private String imageUrl;                // 图片URL
    private ImageType type;                 // 图片类型 (1-主图，2-详情图，3-缩略图)
    private int sortOrder;                  // 排序权重
}