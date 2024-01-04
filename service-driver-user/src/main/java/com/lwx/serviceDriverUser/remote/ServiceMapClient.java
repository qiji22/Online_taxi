package com.lwx.serviceDriverUser.remote;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.TerminalResponse;
import com.lwx.internalcommon.response.TrackResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-map")
public interface ServiceMapClient {

    @PostMapping("/terminal/add")
    public ResponseResult<TerminalResponse> addTerminal(@RequestParam String name,@RequestParam String desc);

    @PostMapping("/track/add")
    public ResponseResult<TrackResponse> addTrack(@RequestParam String tid);
}
