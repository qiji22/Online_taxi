package com.lwx.serviceDriverUser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.internalcommon.dto.DriverUser;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverUserMapper extends BaseMapper<DriverUser> {
    public DriverUser findList();
}
