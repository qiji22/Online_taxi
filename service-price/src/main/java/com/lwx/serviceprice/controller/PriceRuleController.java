package com.lwx.serviceprice.controller;

import com.github.pagehelper.PageInfo;
import com.lwx.internalcommon.dto.PriceRule;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.serviceprice.service.IPriceRuleService;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: MR_LWX
 * @CreateTime: 2024-02-02  16:04
 */
@RestController
@RequestMapping("/price-rule")
public class PriceRuleController {

    @Autowired
    private IPriceRuleService priceRuleService;

    @PostMapping("/add")
    public ResponseResult add(@RequestBody PriceRule priceRule) {
        return null;
    }

    /*** 通过指定参数，分页查询用户列表
     * @param
     * @return
     */
    @GetMapping("/page")
    public PageInfo<PriceRule> page(@RequestParam Map<String, Object> params) {
        return priceRuleService.page(params);
    }
}
