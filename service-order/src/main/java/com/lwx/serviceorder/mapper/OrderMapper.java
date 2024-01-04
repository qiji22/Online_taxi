package com.lwx.serviceorder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.internalcommon.dto.OrderInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<OrderInfo> {

}
