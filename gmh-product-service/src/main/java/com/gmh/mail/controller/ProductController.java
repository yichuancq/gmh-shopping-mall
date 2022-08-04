package com.gmh.mail.controller;

import com.gmh.mail.common.exception.ResultCode;
import com.gmh.mail.common.response.ResultData;
import com.gmh.mail.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

/**
 * @author yichuan
 */
@RequestMapping(value = "/product")
@Slf4j
@RestController
@Api(tags = "商品管理", value = "product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * findById
     *
     * @return
     */
    @GetMapping(value = "/findById")
    @ApiOperation(value = "/findById", notes = "findById")
    public ResultData<?> findById(@RequestParam("id") BigInteger id) {
        try {
            return new ResultData<>(ResultCode.SUCCESS, productService.findById(id));
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
            return new ResultData<>(ResultCode.SUCCESS, productService.saveProduct());
        } catch (Exception exception) {
            return new ResultData<>(ResultCode.FAIL, exception.getMessage());
        }
    }

}
