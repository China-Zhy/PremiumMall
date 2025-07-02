package com.nxu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付状态
 */
@Getter
@AllArgsConstructor
public enum PaymentStatus {
    UNPAID(0, "未支付"), PAID(1, "已支付"), FAILED(2, "支付失败"), REFUNDED(3, "已退款"), PARTIAL_REFUNDED(4, "部分退款");

    @EnumValue // 告诉MyBatis-Plus将枚举的哪个属性映射到数据库字段
    private final Integer code;
    private final String description;

    // 根据code获取对应的枚举值
    public static PaymentStatus of(Integer code) {
        if (code == null) {
            return null;
        }
        for (PaymentStatus status : PaymentStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        return null;
    }
}