package com.nxu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 评论状态
 */
@Getter
@AllArgsConstructor
public enum ReviewStatus {
    HIDDEN(0, "隐藏"), DISPLAYED(1, "显示");

    @EnumValue // 告诉MyBatis-Plus将枚举的哪个属性映射到数据库字段
    private final Integer code;
    private final String description;

    // 根据code获取对应的枚举值
    public static ReviewStatus of(Integer code) {
        if (code == null) {
            return null;
        }
        for (ReviewStatus status : ReviewStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        return null;
    }

    // 判断是否显示
    public boolean isDisplayed() {
        return this == DISPLAYED;
    }

    // 判断是否隐藏
    public boolean isHidden() {
        return this == HIDDEN;
    }
}