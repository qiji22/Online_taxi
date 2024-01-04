package com.lwx.apipassenger.controller;

import com.lwx.apipassenger.service.IServiceOrderService;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-27  13:45
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IServiceOrderService iServiceOrderService;

    /*
     * @description:创建订单
     * @return:
     **/
    @PostMapping("/add")
    public ResponseResult saveOrder(@RequestBody OrderRequest orderRequest){
        return iServiceOrderService.saveOrder(orderRequest);
    }
}
