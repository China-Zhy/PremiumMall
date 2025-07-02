package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.ProductStatus;
import com.nxu.enums.YesNoStatus;
import lombok.Data;

/**
 * 商品信息
 */
@Data
@TableName("product")
public class Product {
    private long id;                        // 商品ID
    private int categoryId;                 // 分类ID
    private int brandId;                    // 品牌ID
    private String name;                    // 商品名称
    private String subtitle;                // 副标题
    private String mainImage;               // 主图链接
    private String subImages;               // 子图(JSON数组)
    private String detail;                  // 商品详情
    private double price;                   // 销售价格
    private double originalPrice;           // 商品原价
    private double costPrice;               // 成本价
    private double weight;                  // 重量(kg)
    private double length;                  // 长度(cm)
    private double width;                   // 宽度(cm)
    private double height;                  // 高度(cm)
    private double volume;                  // 体积(m³)
    private long stock;                     // 库存数量
    private int minStock;                   // 库存预警值
    private long salesVolume;               // 销量
    private int reviewsCount;               // 评论数
    private int favoritesCount;             // 收藏数
    private ProductStatus status;           // 商品状态 (0-下架，1-在售，2-删除，3-草稿)
    private YesNoStatus isHot;              // 是否热门商品 (0-否，1-是)
    private YesNoStatus isNew;              // 是否新品 (0-否，1-是)
    private YesNoStatus isRecommend;        // 是否推荐 (0-否，1-是)
    private int sortOrder;                  // 排序权重
}