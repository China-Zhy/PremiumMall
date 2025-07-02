package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 商品属性值
 */
@Data
@TableName("attr_value")
public class AttrValue {
    private long id;                        // 属性值ID
    private long attrKeyId;                 // 属性ID
    private String value;                   // 属性值
    private int sortOrder;                  // 排序权重
}