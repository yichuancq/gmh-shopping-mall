package com.gmh.order.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gmh.order.domain.OrderEntity;
import com.gmh.order.mapper.OrderMapper;
import com.gmh.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author yichuan
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {


    /**
     * @return
     * @throws Exception
     */
    @Override
    public boolean saveOrder() throws Exception {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(BigInteger.valueOf(Long.parseLong(IdWorker.getIdStr())));
        orderEntity.setOrderNumber(2);
        orderEntity.setCreateTime(new Date());
        orderEntity.setUpdateTime(new Date());
        boolean flag = this.save(orderEntity);
        return flag;
    }
}
