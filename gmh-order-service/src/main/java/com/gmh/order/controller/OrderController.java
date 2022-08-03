package com.gmh.order.controller;

import com.gmh.mail.common.exception.ResultCode;
import com.gmh.mail.common.response.ResultData;
import com.gmh.order.domain.OrderEntity;
import com.gmh.order.service.OrderService;
import com.gmh.order.vo.RequestParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yichuan
 */
@RequestMapping(value = "/order")
@Slf4j
@RestController
@Api(tags = "订单管理", value = "order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * info
     *
     * @param requestParams
     * @return
     */
    @PostMapping(value = "/info")
    @ApiOperation(value = "/info", notes = "订单info")
    public ResultData<?> info(@RequestBody RequestParams requestParams) {
        log.info("info->requestParams:{}", requestParams);
        return new ResultData<>(ResultCode.SUCCESS, requestParams);
    }

    /**
     * @return
     */
    @GetMapping(value = "/test")
    @ApiOperation(value = "/test", notes = "test")
    public ResultData<?> test() {
        log.info("info->test:{}");
        return new ResultData<>(ResultCode.SUCCESS, "hello");
    }

    /**
     * findById
     *
     * @return
     */
    @GetMapping(value = "/findById")
    @ApiOperation(value = "/findById", notes = "findById")
    public ResultData<?> findById(Integer id) {
        log.info("info->findById:{}", id);
        OrderEntity entity = orderService.getBaseMapper().selectById(1);
        if (entity != null) {
            log.info("entity:{}", entity);
        }
        return new ResultData<>(ResultCode.SUCCESS, entity);
    }

    /**
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "/list", notes = "list")
    public ResultData<?> list() {
        log.info("info->list");
        return new ResultData<>(ResultCode.SUCCESS, orderService.list());
    }


}
