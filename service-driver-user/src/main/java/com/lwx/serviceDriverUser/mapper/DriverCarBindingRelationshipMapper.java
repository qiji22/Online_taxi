package com.lwx.serviceDriverUser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.internalcommon.dto.DriverCarBindingRelationship;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverCarBindingRelationshipMapper extends BaseMapper<DriverCarBindingRelationship> {
    public DriverCarBindingRelationship findList();
}
