package com.gmh.order.controller;

import com.gmh.mail.common.exception.ResultCode;
import com.gmh.mail.common.response.ResultData;
import com.gmh.order.vo.RequestParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author yichuan
 */
@RequestMapping(value = "/order")
@Slf4j
@RestController
@Api(tags = "订单管理", value = "order")
public class OrderController {

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
}
