package com.lwx.serviceorder.controller;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.OrderRequest;
import com.lwx.serviceorder.service.IOrderService;
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
public class OrderController {

    @Autowired
    private IOrderService iOrderService;


    @PostMapping("/add")
    public ResponseResult saveOrder(@RequestBody OrderRequest orderRequest){
        return iOrderService.saveOrder(orderRequest);
    }
}
