package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.UserStatus;
import com.nxu.enums.YesNoStatus;
import lombok.Data;

/**
 * 商品属性Key
 */
@Data
@TableName("attr_key")
public class AttrKey {
    private long id;                        // 属性ID
    private int categoryId;                 // 分类ID
    private String name;                    // 属性名称
    private YesNoStatus isFilter;           // 是否用于筛选 (1-是，2-否)
    private YesNoStatus isRequired;         // 是否必填 (1-是，2-否)
    private int sortOrder;                  // 排序权重
    private UserStatus status;              // 属性状态 (0-禁用，1-启用)
}