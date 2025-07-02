package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.UsageStatus;
import lombok.Data;

/**
 * 商品SKU信息
 */
@Data
@TableName("sku")
public class Sku {
    private long id;                        // SKU ID
    private long productId;                 // 商品ID
    private String skuCode;                 // SKU编码
    private String attributes;              // SKU属性(JSON对象)
    private double price;                   // 销售价格
    private double originalPrice;           // 商品原价
    private double costPrice;               // 成本价
    private int lockStock;                  // 锁定库存
    private long salesVolume;               // 销量
    private double weight;                  // 重量(kg)
    private double length;                  // 长度(cm)
    private double width;                   // 宽度(cm)
    private double height;                  // 高度(cm)
    private double volume;                  // 体积(m³)
    private String barcode;                 // 条形码
    private UsageStatus status;             // 状态 (0-禁用，1-启用)
    private int sortOrder;                  // 排序权重
}