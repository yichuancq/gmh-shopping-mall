package com.gmh.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gmh.mail.common.response.ResultData;
import com.gmh.order.domain.OrderEntity;
import com.gmh.order.vo.QueryOrderVo;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yichuan
 */
public interface OrderService extends IService<OrderEntity> {

    /**
     * @return
     * @throws Exception
     */
    boolean saveOrder() throws Exception;

    /**
     * @param id
     * @return
     * @throws Exception
     */
    List<OrderEntity> findById(BigInteger id) throws Exception;

    /**
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteById(BigInteger id) throws Exception;

    /**
     * @param queryOrderVo
     * @return
     */
    ResultData<?> pagerOrderList(QueryOrderVo queryOrderVo) throws Exception;
}
