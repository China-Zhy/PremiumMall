package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.UsageStatus;
import lombok.Data;

/**
 * 商品分类信息
 */
@Data
@TableName("category")
public class Category {
    private int id;                         // 分类ID
    private int parentId;                   // 父分类ID
    private String name;                    // 分类名称
    private int level;                      // 分类级别
    private int sortOrder;                  // 排序权重
    private UsageStatus status;             // 分类状态 (0-禁用，1-启用)
}