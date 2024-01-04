package com.lwx.apipassenger.service.impl;

import com.lwx.apipassenger.remote.ServiceOrderClient;
import com.lwx.apipassenger.service.IServiceOrderService;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-27  14:30
 */
@Service
public class ServiceOrderServiceImpl implements IServiceOrderService {
    @Autowired
    private ServiceOrderClient serviceOrderClient;

    public ResponseResult saveOrder(OrderRequest orderRequest){
        return serviceOrderClient.saveOrder(orderRequest);
    }
}
