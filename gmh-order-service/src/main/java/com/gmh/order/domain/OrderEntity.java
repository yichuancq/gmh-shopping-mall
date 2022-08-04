package com.gmh.order.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gmh.order.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author yichuan
 */


@Data
@Builder
@TableName("gmh_order")
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseEntity {
    /**
     *
     */
    @TableId(value = "id", type = IdType.INPUT)
    private BigInteger id;
    /**
     * 订单编号
     */
    @TableField(value = "order_number")
    private Integer orderNumber;
    /**
     * 用户昵称
     */
    @TableField(value = "user_nickname")
    private String userNickName;
    /**
     * 运费费用
     */
    @TableField(value = "freight")
    private BigDecimal freight;
}
