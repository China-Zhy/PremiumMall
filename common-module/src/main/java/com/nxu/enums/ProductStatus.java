package com.nxu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品状态
 */
@Getter
@AllArgsConstructor
public enum ProductStatus {
    OFFLINE(0, "下架"), ON_SALE(1, "在售"), DELETED(2, "删除"), DRAFT(3, "草稿");

    @EnumValue // 告诉MyBatis-Plus将枚举的哪个属性映射到数据库字段
    private final Integer code;
    private final String description;

    // 根据code获取对应的枚举值
    public static ProductStatus of(Integer code) {
        if (code == null) {
            return null;
        }
        for (ProductStatus status : ProductStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        return null;
    }
}