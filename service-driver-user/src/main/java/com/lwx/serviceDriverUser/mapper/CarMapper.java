package com.lwx.serviceDriverUser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.internalcommon.dto.Car;
import com.lwx.internalcommon.dto.DriverUser;
import org.springframework.stereotype.Repository;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-09  10:27
 */
@Repository
public interface CarMapper extends BaseMapper<Car> {
    public Car findList();
}
