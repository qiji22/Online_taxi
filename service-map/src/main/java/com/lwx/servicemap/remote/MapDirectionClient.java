package com.lwx.servicemap.remote;

import com.lwx.internalcommon.constant.AmapConfigConstants;
import com.lwx.internalcommon.response.DirectionResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-09-04  14:50
 */
@Service
@Slf4j
public class MapDirectionClient {


    @Value("${amap.key}")
    private String amapKey;
    @Autowired
    private RestTemplate restTemplate;

    public DirectionResponse direction(String depLongitude, String depLatitude, String destLongitude, String destLatitude) {
        //组装调用url

        // &key=6bf3fc98525c0dfa1cc8acc4de343b4d
        StringBuffer urlBuild = new StringBuffer();
        urlBuild.append(AmapConfigConstants.DIRECTION_URL);
        urlBuild.append("?");
        urlBuild.append("origin=" + depLongitude + "," + depLatitude);
        urlBuild.append("&");
        urlBuild.append("destination=" + destLongitude + "," + destLatitude);
        urlBuild.append("&");
        urlBuild.append("extensions=base");
        urlBuild.append("&");
        urlBuild.append("output=json");
        urlBuild.append("&");
        urlBuild.append("key=" + amapKey);
        log.info(urlBuild.toString());
        //调用高德接口
        ResponseEntity<String> directionEntity = restTemplate.getForEntity(urlBuild.toString(), String.class);
        String directionString = directionEntity.getBody();
        //解析接口
        DirectionResponse directionResponse = parseDirectionEntity(directionString);

        return directionResponse;
    }


    private DirectionResponse parseDirectionEntity(String directionString) {
        DirectionResponse directionResponse = null;


        try {
            //最外层
            directionResponse = new DirectionResponse();
            JSONObject result = JSONObject.fromObject(directionString);
            if (result.has(AmapConfigConstants.STATUS)) {
                if (result.getInt(AmapConfigConstants.STATUS) == 1) {
                    if (result.has(AmapConfigConstants.ROUTE)) {
                        JSONObject routeObject = result.getJSONObject(AmapConfigConstants.ROUTE);
                        JSONArray pathsArray = routeObject.getJSONArray(AmapConfigConstants.PATHS);
                        JSONObject pathObject = pathsArray.getJSONObject(0);
                        if (pathObject.has(AmapConfigConstants.DISTANCE)) {
                            directionResponse.setDistance(pathObject.getInt(AmapConfigConstants.DISTANCE));
                        }
                        if (pathObject.has(AmapConfigConstants.DURATION)) {
                            directionResponse.setDuration(pathObject.getInt(AmapConfigConstants.DURATION));
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return directionResponse;
    }

}
