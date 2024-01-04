package com.lwx.servicemap.remote;

import com.lwx.internalcommon.constant.AmapConfigConstants;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.TerminalResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-24  13:39
 */
@Service
public class TerminalClient {

    @Value("${amap.key}")
    private String amapKey;

    @Value("${amap.sid}")
    private String sid;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult<TerminalResponse> add(String name,String desc){
        //平装请求的url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.TERMINAL_ADD_URL);
        url.append("?");
        url.append("key="+amapKey);
        url.append("&");
        url.append("sid="+sid);//默认写死
        url.append("&");
        url.append("name="+name);
        url.append("&");
        url.append("desc="+desc);
        ResponseEntity<String> forEntity = restTemplate.postForEntity(url.toString(),null, String.class);
        String body = forEntity.getBody();
        JSONObject result = JSONObject.fromObject(body);
        JSONObject data = result.getJSONObject("data");
        String tid = data.getString("tid");
        TerminalResponse terminalResponse = new TerminalResponse();
        terminalResponse.setTid(tid);
        return ResponseResult.success(terminalResponse);
    }


    public ResponseResult<List<TerminalResponse>> aroundSearch(String center, Integer radius){
        //平装请求的url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.TERMINAL_SEARCH_URL);
        url.append("?");
        url.append("key="+amapKey);
        url.append("&");
        url.append("sid="+sid);//默认写死
        url.append("&");
        url.append("center="+center);
        url.append("&");
        url.append("radius="+radius);
        ResponseEntity<String> forEntity = restTemplate.postForEntity(url.toString(),null, String.class);
        String body = forEntity.getBody();
        JSONObject result = JSONObject.fromObject(body);
        JSONObject data = result.getJSONObject("data");
        JSONArray results = data.getJSONArray("results");
        ArrayList<TerminalResponse> terminalResponseList = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            TerminalResponse terminalResponse = new TerminalResponse();
            JSONObject jsonObject = results.getJSONObject(i);
            Long carId = jsonObject.getLong("desc");
            String tid = jsonObject.getString("tid");
            terminalResponse.setTid(tid);
            terminalResponse.setCarId(carId);
            terminalResponseList.add(terminalResponse);
        }
        return ResponseResult.success(terminalResponseList);
    }
}
