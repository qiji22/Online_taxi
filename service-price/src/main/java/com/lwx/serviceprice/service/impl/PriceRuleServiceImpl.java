package com.lwx.serviceprice.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwx.internalcommon.dto.PriceRule;
import com.lwx.serviceprice.mapper.PriceRuleMapper;
import com.lwx.serviceprice.service.IPriceRuleService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: MR_LWX
 * @CreateTime: 2024-02-02  15:17
 */
@Service
public class PriceRuleServiceImpl extends ServiceImpl<PriceRuleMapper, PriceRule> implements IPriceRuleService {

    @Autowired
    private PriceRuleMapper priceRuleMapper;

    /**
     * 分页列表
     *
     * @param params
     * @return
     */
    @Override
    public PageInfo<PriceRule> page(Map<String, Object> params) {
        //开启分页
        Integer curPage = MapUtils.getInteger(params, "page");
        Integer limit = MapUtils.getInteger(params, "limit");
        Page<PriceRule> page = new Page<>(curPage == null ? 0 : curPage, limit == null ? -1 : limit);
        PageHelper.startPage(curPage, limit);
        List<PriceRule> list = baseMapper.findList(page, params);
        //返回分页对象
        return new PageInfo<PriceRule>(list);
    }
}
