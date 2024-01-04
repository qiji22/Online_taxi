package com.lwx.servicemap.controller;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.TerminalResponse;
import com.lwx.servicemap.service.ITeminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-24  13:38
 */
@RestController
@RequestMapping("/terminal")
public class TeminalController {

    @Autowired
    private ITeminalService iTeminalService;

    @PostMapping("/add")
    public ResponseResult<TerminalResponse> add(String name,String desc){
        return iTeminalService.add(name,desc);
    }

    @PostMapping("/aroundsearch")
    public ResponseResult<List<TerminalResponse>> aroundsearch(@RequestParam("center") String center, @RequestParam("radius") Integer radius){
        return iTeminalService.aroundsearch(center, radius);
    }
}
