package com.lwx.apipassenger.service;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.OrderRequest;

public interface IServiceOrderService {
    public ResponseResult saveOrder(OrderRequest orderRequest);
}
