package com.gmh.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gmh.order.domain.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * order
 *
 * @author yichuan
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {
}
