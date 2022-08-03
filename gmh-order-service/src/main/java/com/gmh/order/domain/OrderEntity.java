package com.gmh.order.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gmh.order.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @TableId(value = "id")
    private Integer id;

    /**
     *
     */
    @TableField(value = "order_number")
    private Integer orderNumber;

}
