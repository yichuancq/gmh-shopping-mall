package com.gmh.order.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.gmh.mail.common.request.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 * @author yichuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryOrderVo extends PageRequest {

    @ApiModelProperty(value = "orderId", notes = "订单Id")
    private BigInteger orderId;

    @ApiModelProperty(value = "orderNumber", notes = "订单号")
    private BigInteger orderNumber;

    @ApiModelProperty(value = "nickName", notes = "订单用户昵称")
    private String nickName;

    @ApiModelProperty(value = "startTime", notes = "开始时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String startTime;

    @ApiModelProperty(value = "endTime", notes = "结束时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String endTime;

}
