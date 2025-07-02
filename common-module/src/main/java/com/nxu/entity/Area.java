package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.AreaLevel;
import lombok.Data;

/**
 * 地域信息
 */
@Data
@TableName("area")
public class Area {
    private String code;                // 地域编码
    private String name;                // 地域名称
    private String fullName;            // 地域全称
    private String parentCode;          // 上级编码
    private AreaLevel level;            // 地域级别 (1-省，2-市，3-县)
}