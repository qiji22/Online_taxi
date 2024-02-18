package com.lwx.serviceprice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwx.internalcommon.dto.PriceRule;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PriceRuleMapper extends BaseMapper<PriceRule> {

    List<PriceRule> findList(Page<PriceRule> page, @Param("p")Map<String,Object> params);
}
