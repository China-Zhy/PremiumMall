package com.nxu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付类型
 */
@Getter
@AllArgsConstructor
public enum PaymentType {
    ALIPAY(1, "支付宝"), WECHAT_PAY(2, "微信支付"), ONLINE_BANKING(3, "网银支付");

    @EnumValue // 告诉MyBatis-Plus将枚举的哪个属性映射到数据库字段
    private final Integer code;
    private final String description;

    // 根据code获取对应的枚举值
    public static PaymentType of(Integer code) {
        if (code == null) {
            return null;
        }
        for (PaymentType type : PaymentType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}