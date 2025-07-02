package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 订单子项信息
 */
@Data
@TableName("order_item")
public class OrderItem {
    private long id;                        // 订单项ID
    private long orderId;                   // 订单ID
    private long productId;                 // 商品ID
    private long skuId;                     // SKU ID
    private String productName;             // 商品名称
    private String skuAttributes;           // SKU属性
    private double price;                   // 单价
    private int quantity;                   // 数量
    private double totalPrice;              // 总价
}