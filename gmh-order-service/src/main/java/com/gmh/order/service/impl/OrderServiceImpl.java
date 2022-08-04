package com.gmh.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gmh.order.domain.OrderEntity;
import com.gmh.order.mapper.OrderMapper;
import com.gmh.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<OrderEntity> findById(BigInteger id) throws Exception {
        log.info("info->findById:{}", id);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        List<OrderEntity> entityList = this.getBaseMapper().selectList(queryWrapper);
        if (entityList != null) {
            log.info("list size:{}", entityList.size());
        }
        return entityList;
    }
}
