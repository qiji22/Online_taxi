package com.lwx.serviceorder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwx.internalcommon.dto.OrderInfo;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.OrderRequest;

public interface IOrderService extends IService<OrderInfo> {

    public ResponseResult saveOrder(OrderRequest orderRequest);

}
