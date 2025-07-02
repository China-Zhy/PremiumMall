package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.OrderStatus;
import com.nxu.enums.PaymentType;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 订单信息
 */
@Data
@TableName("order")
public class Order {
    private long id;                        // 订单ID
    private String orderNo;                 // 订单编号
    private long userId;                    // 用户ID
    private long addressId;                 // 收货地址ID
    private PaymentType paymentType;        // 支付类型 (1-支付宝，2-微信支付，3-网银支付)
    private double paymentAmount;           // 支付金额
    private LocalDateTime paymentTime;      // 支付时间
    private LocalDateTime shippingTime;     // 发货时间
    private LocalDateTime endTime;          // 完成时间
    private LocalDateTime closeTime;        // 关闭时间
    private OrderStatus status;             // 订单状态 (0-已取消，1-未支付，2-已支付，3-已发货，4-已完成)
    private LocalDateTime createTime;       // 创建时间
    private LocalDateTime updateTime;       // 更新时间
}