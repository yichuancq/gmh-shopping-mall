package com.gmh.order.domain.base;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yichuan
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * 创建时间
     */

    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

}
