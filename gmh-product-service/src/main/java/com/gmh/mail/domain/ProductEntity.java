package com.gmh.mail.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gmh.mail.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 * @author yichuan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("gmh_product")
public class ProductEntity extends BaseEntity {
    /**
     *
     */
    @TableId(value = "id", type = IdType.INPUT)
    private BigInteger id;
    /**
     * 订单编号
     */
    @TableField(value = "product_name")
    private String productName;
}
