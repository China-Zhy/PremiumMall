package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 商品规格信息
 */
@Data
@TableName("specs")
public class Specs {
    private long id;                        // 规格ID
    private long productId;                 // 商品ID
    private String specKey;                 // 规格名称
    private String specValue;               // 规格值
    private int sortOrder;                  // 排序权重
}