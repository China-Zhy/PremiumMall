package com.nxu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态
 */
@Getter
@AllArgsConstructor
public enum UserStatus {
    DISABLED(0, "禁用"), ENABLED(1, "正常"), AUDITING(2, "待审核");

    @EnumValue // 告诉MyBatis-Plus将枚举的哪个属性映射到数据库字段
    private final Integer code;
    private final String description;

    // 根据code获取对应的枚举值
    public static UserStatus of(Integer code) {
        if (code == null) {
            return null;
        }
        for (UserStatus type : UserStatus.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}