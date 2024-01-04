package com.lwx.servicemap.remote;

import com.lwx.internalcommon.constant.AmapConfigConstants;
import com.lwx.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-09-08  09:16
 */
@Service
public class MapDicDistrictClient {
    @Value("${amap.key}")
    private String amapKey;

    @Autowired
    private RestTemplate restTemplate;

    public String dicDistrict(String keywords){

        //平装请求的url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.DISTRICT_URL);
        url.append("?");
        url.append("keywords="+keywords);
        url.append("&");
        url.append("subdistrict=3");//默认写死
        url.append("&");
        url.append("key="+amapKey);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url.toString(), String.class);
        return forEntity.getBody();
    }
}
