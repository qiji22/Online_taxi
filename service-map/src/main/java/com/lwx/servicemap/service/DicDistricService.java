package com.lwx.servicemap.service;

import cn.hutool.json.JSONUtil;
import com.lwx.internalcommon.constant.AmapConfigConstants;
import com.lwx.internalcommon.constant.CommonStatusEnum;
import com.lwx.internalcommon.dto.DicDistrict;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.servicemap.mapper.DicDistrictMapper;
import com.lwx.servicemap.remote.MapDicDistrictClient;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-09-08  08:53
 */
@Service
@Slf4j
public class DicDistricService {
    @Autowired
    private MapDicDistrictClient mapDicDistrictClient;

    @Autowired
    private DicDistrictMapper dicDistrictMapper;

    public ResponseResult initDicDistrict(String keywords) {

        //请求地图
        String dicDistrict = mapDicDistrictClient.dicDistrict(keywords);
        System.out.println(dicDistrict);
        //解析结果
        JSONObject dicDistrictObject = JSONObject.fromObject(dicDistrict);
        if (dicDistrictObject.getInt(AmapConfigConstants.STATUS) != 1) {
            return ResponseResult.fail(CommonStatusEnum.MAP_DISTRICT_ERROR.getCode(), CommonStatusEnum.MAP_DISTRICT_ERROR.getValue());
        }
        if (JSONUtil.isNull(dicDistrictObject.getJSONArray(AmapConfigConstants.DISTRICTS))) {
            return ResponseResult.fail(CommonStatusEnum.MAP_DISTRICT_ERROR.getCode(), CommonStatusEnum.MAP_DISTRICT_ERROR.getValue());
        }
        JSONArray dicDistrictJsonArray = dicDistrictObject.getJSONArray(AmapConfigConstants.DISTRICTS);
        for (int i = 0; i < dicDistrictJsonArray.size(); i++) {
            JSONObject dicDistrictJsonObject = dicDistrictJsonArray.getJSONObject(i);
            String addressCode = dicDistrictJsonObject.getString(AmapConfigConstants.ADCODE);
            String addressName = dicDistrictJsonObject.getString(AmapConfigConstants.NAME);
            String parentAddressCode = "0";
            String level = dicDistrictJsonObject.getString(AmapConfigConstants.LEVEL);

            insertDicDistrict(addressCode, addressName, level, parentAddressCode);

            JSONArray provinceJsonArray = dicDistrictJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
            for (int p = 0; p < provinceJsonArray.size(); p++) {
                JSONObject provinceJsonObject = dicDistrictJsonArray.getJSONObject(p);
                String provinceAddressCode = provinceJsonObject.getString(AmapConfigConstants.ADCODE);
                String provinceAddressName = provinceJsonObject.getString(AmapConfigConstants.NAME);
                String provinceParentAddressCode = addressCode;
                String provinceLevel = provinceJsonObject.getString(AmapConfigConstants.LEVEL);

                insertDicDistrict(provinceAddressCode, provinceAddressName, provinceLevel, provinceParentAddressCode);

                JSONArray cityJsonArray = provinceJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
                for (int c = 0; c < cityJsonArray.size(); c++) {
                    JSONObject cityJsonObject = cityJsonArray.getJSONObject(c);
                    String cityAddressCode = cityJsonObject.getString(AmapConfigConstants.ADCODE);
                    String cityAddressName = cityJsonObject.getString(AmapConfigConstants.NAME);
                    String cityParentAddressCode = provinceAddressCode;
                    String cityLevel = cityJsonObject.getString(AmapConfigConstants.LEVEL);

                    if (cityLevel.equals(AmapConfigConstants.STREET)) {
                        continue;
                    }

                    insertDicDistrict(cityAddressCode, cityAddressName, cityLevel, cityParentAddressCode);
                    JSONArray districtArray = cityJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
                    for (int d = 0; d < districtArray.size(); d++) {
                        JSONObject districtJsonObject = districtArray.getJSONObject(d);
                        String districtAddressCode = districtJsonObject.getString(AmapConfigConstants.ADCODE);
                        String districtAddressName = districtJsonObject.getString(AmapConfigConstants.NAME);
                        String districtParentAddressCode = cityAddressCode;
                        String districtLevel = districtJsonObject.getString(AmapConfigConstants.LEVEL);

                        insertDicDistrict(districtAddressCode, districtAddressName, districtLevel, districtParentAddressCode);

                    }
                }
            }
        }

        return ResponseResult.success();
    }

    public int generateLevel(String level) {
        int levelInt = 0;
        if (level.trim().equals("country")) {
            levelInt = 0;
        } else if (level.trim().equals("province")) {
            levelInt = 1;
        } else if (level.trim().equals("district")) {
            levelInt = 2;
        }

        return levelInt;
    }

    /*
     * @description:插入数据库
     * @return:
     **/
    @Transactional
    public void insertDicDistrict(String addressCode, String addressName, String level, String parentAddressCode) {
        DicDistrict district = new DicDistrict();
        district.setAddressCode(addressCode);
        district.setAddressName(addressName);
        district.setLevel(generateLevel(level));
        district.setParentAddressCode(parentAddressCode);

        dicDistrictMapper.insert(district);
    }
}
