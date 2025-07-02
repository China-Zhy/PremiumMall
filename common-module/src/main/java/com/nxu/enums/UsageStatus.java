package com.nxu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 使用状态
 */
@Getter
@AllArgsConstructor
public enum UsageStatus {
    DISABLED(0, "禁用"), ENABLED(1, "启用");

    @EnumValue // 告诉MyBatis-Plus将枚举的哪个属性映射到数据库字段
    private final Integer code;
    private final String description;

    // 根据code获取对应的枚举值
    public static UsageStatus of(Integer code) {
        if (code == null) {
            return null;
        }
        for (UsageStatus status : UsageStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        return null;
    }

    // 判断是否启用
    public boolean isEnabled() {
        return this == ENABLED;
    }

    // 判断是否禁用
    public boolean isDisabled() {
        return this == DISABLED;
    }
}