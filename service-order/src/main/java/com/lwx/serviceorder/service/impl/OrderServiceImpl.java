package com.lwx.serviceorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwx.internalcommon.constant.OrderConstants;
import com.lwx.internalcommon.dto.OrderInfo;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.OrderRequest;
import com.lwx.serviceorder.mapper.OrderMapper;
import com.lwx.serviceorder.service.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;


/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-27  14:19
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderInfo> implements IOrderService {

    public ResponseResult saveOrder(OrderRequest orderRequest){

        OrderInfo orderInfo = new OrderInfo();
        //将orderRequest中的属性值转化到orderInfo值中去
        BeanUtils.copyProperties(orderRequest,orderInfo);
        //初始化订单状态
        orderInfo.setOrderStatus(OrderConstants.ORDER_START);
        LocalDateTime now = LocalDateTime.now();
        orderInfo.setGmtCreate(now);
        baseMapper.insert(orderInfo);
        return ResponseResult.success("添加成功!");
    }

}
