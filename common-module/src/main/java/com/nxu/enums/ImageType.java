package com.nxu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 图片类型
 */
@Getter
@AllArgsConstructor
public enum ImageType {
    MAIN(1, "主图"), DETAIL(2, "详情图"), THUMBNAIL(3, "缩略图");

    @EnumValue // 告诉MyBatis-Plus将枚举的哪个属性映射到数据库字段
    private final Integer code;
    private final String description;

    // 根据code获取对应的枚举值
    public static ImageType of(Integer code) {
        if (code == null) {
            return null;
        }
        for (ImageType type : ImageType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}