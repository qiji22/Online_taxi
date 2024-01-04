package com.lwx.servicemap.remote;

import com.lwx.internalcommon.constant.AmapConfigConstants;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.PointDTO;
import com.lwx.internalcommon.request.PointRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-25  16:00
 */

@Service
public class PointClient {

    @Value("${amap.key}")
    private String amapKey;

    @Value("${amap.sid}")
    private String sid;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult upload(PointRequest pointRequest){
        //平装请求的url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.POINT_UPLOAD_URL);
        url.append("?");
        url.append("key="+amapKey);
        url.append("&");
        url.append("sid="+sid);//默认写死
        url.append("&");
        url.append("tid="+pointRequest.getTid());
        url.append("&");
        url.append("trid="+pointRequest.getTrid());
        url.append("&");
        url.append("points=");
        PointDTO[] points = pointRequest.getPoints();
        url.append("%5B");
        for (PointDTO point : points) {
            url.append("%7B");
            String locatetime = point.getLocatetime();
            String location = point.getLocation();
            url.append("%22location%22");
            url.append("%3A");
            url.append("%22"+location+"%22");
            url.append("%2C");
            url.append("%22locatetime%22");
            url.append("%3A");
            url.append("%22"+locatetime+"%22");
            url.append("%7D");
        }
        url.append("%5D");
        ResponseEntity<String> forEntity = restTemplate.postForEntity(URI.create(url.toString()),null, String.class);
        String body = forEntity.getBody();
        System.out.println("上传轨迹点返回值："+body);
        JSONObject result = JSONObject.fromObject(body);

        return ResponseResult.success();
    }
}
