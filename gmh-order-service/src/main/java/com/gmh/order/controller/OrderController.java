package com.gmh.order.controller;

import com.gmh.mail.common.exception.ResultCode;
import com.gmh.mail.common.response.ResultData;
import com.gmh.order.service.OrderService;
import com.gmh.order.vo.QueryOrderVo;
import com.gmh.order.vo.RequestParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

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
     * findById
     *
     * @return
     */
    @GetMapping(value = "/findById")
    @ApiOperation(value = "/findById", notes = "findById")
    public ResultData<?> findById(@RequestParam("id") BigInteger id) {
        try {
            return new ResultData<>(ResultCode.SUCCESS, orderService.findById(id));
        } catch (Exception exception) {
            return new ResultData<>(ResultCode.FAIL, exception.getMessage());
        }
    }

    /**
     * deleteById
     *
     * @return
     */
    @GetMapping(value = "/deleteById")
    @ApiOperation(value = "/deleteById", notes = "deleteById")
    public ResultData<?> deleteById(@RequestParam("id") BigInteger id) {
        try {
            return new ResultData<>(ResultCode.SUCCESS, orderService.deleteById(id));
        } catch (Exception exception) {
            return new ResultData<>(ResultCode.FAIL, exception.getMessage());
        }
    }

    /**
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "/list", notes = "list")
    public ResultData<?> list() {
        log.info("info->list");
        try {
            return new ResultData<>(ResultCode.SUCCESS, orderService.list());
        } catch (Exception exception) {
            return new ResultData<>(ResultCode.FAIL, exception.getMessage());
        }
    }

    /**
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "/save", notes = "save")
    public ResultData<?> save() {
        log.info("info->save");
        try {
            return new ResultData<>(ResultCode.SUCCESS, orderService.saveOrder());
        } catch (Exception exception) {
            return new ResultData<>(ResultCode.FAIL, exception.getMessage());
        }
    }

    /**
     * 订单分页查询
     *
     * @return
     */
    @PostMapping("/pagerOrderList")
    @ApiOperation(value = "/pagerOrderList", notes = "订单分页查询")
    public ResultData<?> pagerOrderList(@RequestBody QueryOrderVo queryOrderVo) {
        log.info("pagerOrderList->");
        try {
            return orderService.pagerOrderList(queryOrderVo);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            exception.printStackTrace();
            return new ResultData<>(ResultCode.FAIL, exception.getMessage());
        }

    }
}
