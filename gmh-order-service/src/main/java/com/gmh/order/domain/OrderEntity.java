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
     *
     */
    @TableField(value = "order_number")
    private Integer orderNumber;

}
