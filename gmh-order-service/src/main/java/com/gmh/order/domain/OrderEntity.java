package com.gmh.order.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gmh.order.domain.base.BaseEntity;
import lombok.Data;

/**
 * @author yichuan
 */

@Data
@TableName("gmh_order")
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
