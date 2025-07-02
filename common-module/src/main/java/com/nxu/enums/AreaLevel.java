package com.nxu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 地域级别
 */
@Getter
@AllArgsConstructor
public enum AreaLevel {
    ONE(1, "省"), TWO(2, "市"), THREE(3, "县");

    @EnumValue // 告诉MyBatis-Plus将枚举的哪个属性映射到数据库字段
    private final Integer code;
    private final String description;

    // 根据code获取对应的枚举值
    public static AreaLevel of(Integer code) {
        if (code == null) {
            return null;
        }
        for (AreaLevel type : AreaLevel.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}