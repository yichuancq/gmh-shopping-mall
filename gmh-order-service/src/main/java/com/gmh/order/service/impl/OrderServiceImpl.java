package com.gmh.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gmh.mail.common.exception.ResultCode;
import com.gmh.mail.common.response.ResultData;
import com.gmh.order.domain.OrderEntity;
import com.gmh.order.mapper.OrderMapper;
import com.gmh.order.service.OrderService;
import com.gmh.order.utils.PageUtils;
import com.gmh.order.vo.QueryOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
     * saveOrder
     *
     * @return
     * @throws Exception
     */
    @Override
    public boolean saveOrder() throws Exception {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(BigInteger.valueOf(Long.parseLong(IdWorker.getIdStr())));
        orderEntity.setOrderNumber(2);
        orderEntity.setFreight(BigDecimal.valueOf(88.88));
        orderEntity.setUserNickName("用户昵称");
        orderEntity.setCreateTime(new Date());
        orderEntity.setUpdateTime(new Date());
        boolean flag = this.save(orderEntity);
        return flag;
    }

    /**
     * findById
     *
     * @param id
     * @return
     * @throws Exception
     */
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

    /**
     * deleteById
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteById(BigInteger id) throws Exception {
        if (id == null || StringUtils.isEmpty(id.toString())) {
            throw new Exception("Id 为空");
        }
        int n = this.getBaseMapper().deleteById(id);
        if (n > 0) {
            return true;
        }
        return false;
    }

    /**
     * 分页查询订单
     *
     * @param queryOrderVo
     * @return
     */

    @Override
    public ResultData<?> pagerOrderList(QueryOrderVo queryOrderVo) throws Exception {
        if (queryOrderVo == null) {
            throw new Exception("查询参数为空");
        }
        IPage<OrderEntity> pageParams = new Page<>();
        //当前页
        pageParams.setCurrent(queryOrderVo.getPageNumber());
        //每页条数
        pageParams.setSize(queryOrderVo.getPageSize());
        //分页查询
        QueryWrapper<OrderEntity> queryWrapper = new QueryWrapper<>();
        //订单号
        if (queryOrderVo.getOrderNumber() != null) {
            queryWrapper.eq("order_number", queryOrderVo.getOrderNumber());
        }
        //购买用户昵称
        if (queryOrderVo.getNickName() != null) {
            queryWrapper.eq("user_nickname", queryOrderVo.getNickName());
        }
        //开始时间和结束时间
        if (queryOrderVo.getStartTime() != null && queryOrderVo.getEndTime() != null) {
            if (!queryOrderVo.getStartTime().isEmpty() && !queryOrderVo.getEndTime().isEmpty()) {
                queryWrapper.between("create_time", queryOrderVo.getStartTime(), queryOrderVo.getEndTime());
            }
        }
        queryWrapper.orderByDesc("create_time");
        //
        IPage<OrderEntity> orderPage = this.getBaseMapper().selectPage(pageParams, queryWrapper);
        return new ResultData(ResultCode.SUCCESS, new PageUtils(orderPage.getRecords(), (int) orderPage.getTotal(),
                (int) pageParams.getSize(), (int) pageParams.getCurrent()));
    }
}
