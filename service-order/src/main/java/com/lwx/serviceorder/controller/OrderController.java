package com.lwx.serviceorder.controller;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.OrderRequest;
import com.lwx.serviceorder.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-27  14:13
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;


    @PostMapping("/add")
    @ApiOperation(value = "添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "int")
    })
    public ResponseResult saveOrder(@RequestBody OrderRequest orderRequest){
        return iOrderService.saveOrder(orderRequest);
    }
}
