package com.lwx.servicemap.service.Impl;

import com.lwx.internalcommon.constant.AmapConfigConstants;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.servicemap.remote.ServiceClient;
import com.lwx.servicemap.service.IServiceFromMapService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-19  09:19
 */
@Service
public class ServiceFromMapServiceImpl implements IServiceFromMapService {

    @Autowired
    private ServiceClient serviceClient;

    /*
     * @description:创建服务
     * @return:
     **/
    public ResponseResult add(String name){
        return serviceClient.add(name);
    }
}
