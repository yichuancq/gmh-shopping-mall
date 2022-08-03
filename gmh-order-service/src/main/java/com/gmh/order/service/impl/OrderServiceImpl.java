package com.gmh.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gmh.order.domain.OrderEntity;
import com.gmh.order.mapper.OrderMapper;
import com.gmh.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yichuan
 */
@Slf4j
@Service
public class OrderServiceImpl  extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {
}
