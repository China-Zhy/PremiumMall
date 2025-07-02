package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.UsageStatus;
import lombok.Data;

/**
 * 商品品牌信息
 */
@Data
@TableName("brand")
public class Brand {
    private int id;                         // 品牌ID
    private String name;                    // 品牌名称
    private String logo;                    // 品牌LOGO
    private String description;             // 品牌描述
    private int sortOrder;                  // 排序权重
    private UsageStatus status;             // 品牌状态 (0-禁用，1-启用)
}