package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.YesNoStatus;
import lombok.Data;

/**
 * 收货地址信息
 */
@Data
@TableName("address")
public class Address {
    @TableId(type = IdType.AUTO)            // 自增主键
    private long id;                        // 收货地址ID
    private long userId;                    // 用户ID
    private String receiverName;            // 收货人姓名
    private String receiverPhone;           // 收货人电话
    private String provinceCode;            // 省份编码
    private String cityCode;                // 城市编码
    private String districtCode;            // 地区编码
    private String provinceName;            // 省份名称
    private String cityName;                // 城市名称
    private String districtName;            // 地区名称
    private String addressDetail;           // 详细地址
    private YesNoStatus isDefault;          // 是否默认地址 (1-是，2-否)
}