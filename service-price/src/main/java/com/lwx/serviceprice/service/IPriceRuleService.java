package com.lwx.serviceprice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lwx.internalcommon.dto.PriceRule;

import java.util.Map;

public interface IPriceRuleService extends IService<PriceRule> {

    PageInfo<PriceRule> page(Map<String, Object> params);

}
