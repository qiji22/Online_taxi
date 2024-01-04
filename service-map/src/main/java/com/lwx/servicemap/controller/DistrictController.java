package com.lwx.servicemap.controller;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.servicemap.service.DicDistricService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-09-08  08:52
 */
@RestController
@Api(tags = "字典表")
public class DistrictController {
    @Autowired
    private DicDistricService dicDistricService;

    @ApiOperation(value = "查询字典")
    @GetMapping("/dic-district")
    public ResponseResult initDistrict(String keywords){
        return dicDistricService.initDicDistrict(keywords);
    }
}
