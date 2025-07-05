package com.nxu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通用是否状态
 */
@Getter
@AllArgsConstructor
public enum YesNoStatus {
    YES(1, "是"), NO(2, "否");

    @EnumValue // 告诉MyBatis-Plus将枚举的哪个属性映射到数据库字段
    @JsonValue // 告诉Jackson使用code值进行序列化和反序列化
    private final Integer code;
    private final String description;

    // 根据code获取对应的枚举值
    public static YesNoStatus of(Integer code) {
        if (code == null) {
            return null;
        }
        for (YesNoStatus status : YesNoStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        return null;
    }

    // 判断是否为"是"
    public boolean isYes() {
        return this == YES;
    }

    // 判断是否为"否"
    public boolean isNo() {
        return this == NO;
    }
}