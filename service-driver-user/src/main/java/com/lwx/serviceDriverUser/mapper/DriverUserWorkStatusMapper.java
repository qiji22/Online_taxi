package com.lwx.serviceDriverUser.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.internalcommon.dto.DriverUserWorkStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverUserWorkStatusMapper extends BaseMapper<DriverUserWorkStatus> {
    public DriverUserWorkStatus findList();
}
