package com.lwx.servicemap.remote;

import com.lwx.internalcommon.constant.AmapConfigConstants;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.TrackResponse;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-24  14:50
 */
@Service
public class TrackClient {

    @Value("${amap.key}")
    private String amapKey;

    @Value("${amap.sid}")
    private String sid;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult<TrackResponse> add(String tid){
        //平装请求的url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.TRACK_ADD_URL);
        url.append("?");
        url.append("key="+amapKey);
        url.append("&");
        url.append("sid="+sid);//默认写死
        url.append("&");
        url.append("tid="+tid);
        ResponseEntity<String> forEntity = restTemplate.postForEntity(url.toString(),null, String.class);
        String body = forEntity.getBody();
        JSONObject result = JSONObject.fromObject(body);
        JSONObject data = result.getJSONObject("data");
        String trid = data.getString("trid");

        String trname = "";
        if (data.has("trname")){
            trname = data.getString("trname");
        }
        TrackResponse trackResponse = new TrackResponse();
        trackResponse.setTrid(trid);
        trackResponse.setTrname(trname);
        return ResponseResult.success(trackResponse);
    }
}
