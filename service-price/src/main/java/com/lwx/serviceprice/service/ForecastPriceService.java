package com.lwx.serviceprice.service;

import com.lwx.internalcommon.constant.CommonStatusEnum;
import com.lwx.internalcommon.dto.PriceRule;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.ForecastPriceDTO;
import com.lwx.internalcommon.response.DirectionResponse;
import com.lwx.internalcommon.response.ForecastPriceResponse;
import com.lwx.internalcommon.util.BigDecimalUtils;
import com.lwx.serviceprice.mapper.PriceRuleMapper;
import com.lwx.serviceprice.remote.ServiceMapClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-09-04  16:41
 */
@Service
@Slf4j
public class ForecastPriceService {

    @Autowired
    private ServiceMapClient serviceMapClient;

    @Autowired
    private PriceRuleMapper priceRuleMapper;

    public ResponseResult forecastPrice(String depLongitude, String depLatitude, String destLongitude, String destLatitude) {

        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDestLongitude(destLongitude);
        forecastPriceDTO.setDestLatitude(destLatitude);
        ResponseResult<DirectionResponse> direction = serviceMapClient.direction(forecastPriceDTO);
        Integer distance = direction.getData().getDistance();
        Integer duration = direction.getData().getDuration();
        log.info("距离： " + distance + "，时长： " + duration);
        //读取计价规则
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("city_code", "110000");
        queryMap.put("vehicle_type", "1");
        List<PriceRule> priceRules = priceRuleMapper.selectByMap(queryMap);
        if (priceRules.size() == 0) {
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EXISTS.getCode(), CommonStatusEnum.PRICE_RULE_EXISTS.getValue());
        }
        PriceRule priceRule = priceRules.get(0);
        //根据距离，时长和计价规则，计算价格
        double price = this.getPrice(distance, duration, priceRule);

        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(price);
        return ResponseResult.success(forecastPriceResponse);
    }


    /*
     * @description:根据距离，时长和计价规则，计算最终价格
     **/
    private double getPrice(Integer distance, Integer duration, PriceRule priceRule) {
        double price = 0.0;

        //1.起步价
        double startFare = priceRule.getStartFare();
        price = BigDecimalUtils.add(price, startFare);
        //2.里程费
        //2.1总里程 m
        double distanceMile = BigDecimalUtils.divide(distance, 1000);
        //2.2起步的里程
        double startMile = (double) priceRule.getStartMile();
        double distanceSubtract = BigDecimalUtils.substract(distanceMile, startMile);
        //2.3最终收费的里层数 km
        double mile = distanceSubtract < 0 ? 0 : distanceSubtract;
        //2.4计程单价 元/km
        double unitPricePerMile = priceRule.getUnitPricePerMile();
        //2.5里程价格
        double mileFare = BigDecimalUtils.multiply(mile, unitPricePerMile);
        price = BigDecimalUtils.add(price, mileFare);
        //3.时长费
        //时长的分钟数
        double timeMinute = BigDecimalUtils.divide(duration, 60);
        //及时单价
        double unitPricePerMinute = priceRule.getUnitPricePerMinute();
        //时长费用
        double timeFare = BigDecimalUtils.multiply(timeMinute, unitPricePerMinute);
        price = BigDecimalUtils.add(price, timeFare);

        BigDecimal priceBigDecimal = BigDecimal.valueOf(price);
        priceBigDecimal = priceBigDecimal.setScale(2, BigDecimal.ROUND_UP);


        return priceBigDecimal.doubleValue();
    }
}
