package com.gmh.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gmh.order.domain.OrderEntity;

/**
 * @author yichuan
 */
public interface OrderService extends IService<OrderEntity> {

    /**
     * @return
     * @throws Exception
     */
    boolean saveOrder() throws Exception;
}
