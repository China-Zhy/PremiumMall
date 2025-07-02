package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.YesNoStatus;
import lombok.Data;

/**
 * 购物车信息
 */
@Data
@TableName("cart")
public class Cart {
    private long id;                        // 购物车ID
    private long userId;                    // 用户ID
    private long productId;                 // 商品ID
    private long skuId;                     // SKU ID
    private int quantity;                   // 数量
    private YesNoStatus selected;           // 是否选中 (0-否，1-是)
    private YesNoStatus deleted;            // 是否删除 (0-否，1-是)
}