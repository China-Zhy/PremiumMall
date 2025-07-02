package com.nxu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nxu.enums.PaymentStatus;
import com.nxu.enums.PaymentType;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 支付信息
 */
@Data
@TableName("payment")
public class Payment {
    private long id;                        // 记录ID
    private long orderId;                   // 订单ID
    private String paymentNo;               // 支付流水号
    private PaymentType paymentType;        // 支付类型 (1-支付宝，2-微信支付，3-网银支付)
    private double paymentAmount;           // 支付金额
    private PaymentStatus status;           // 支付状态 (0-未支付，1-已支付，2-支付失败，3-已退款，4-部分退款)
    private String transactionId;           // 第三方支付交易号
    private LocalDateTime paymentTime;      // 支付完成时间
    private LocalDateTime refundTime;       // 退款时间
    private double refundAmount;            // 退款金额
    private String errorCode;               // 错误代码
    private String errorMsg;                // 错误信息
    private String extraInfo;               // 扩展信息 (支付渠道返回的额外参数)
    private LocalDateTime createTime;       // 创建时间
    private LocalDateTime updateTime;       // 更新时间
}