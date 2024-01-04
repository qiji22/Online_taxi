package com.lwx.servicePassengerUser.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lwx.internalcommon.constant.CommonStatusEnum;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.servicePassengerUser.mapper.PassengerUserMapper;
import com.lwx.servicePassengerUser.pojo.PassengerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-03  16:03
 */
@Service
public class UserService {

    @Autowired
    private PassengerUserMapper passengerUserMapper;

    public ResponseResult  loginOrReg(String passengerPhone){

        //根据手机号查询用户信息
        Map<String,Object> map = new HashMap<>();
        map.put("passenger_phone",passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);
        //判断用户信息是否存在
        if(passengerUsers.size() == 0){
            //如果不存在，插入用户信息
            PassengerUser passengerUser = new PassengerUser();
            passengerUser.setPassengerName("张三");
            passengerUser.setPassengerGender((byte) 0);
            passengerUser.setPassengerPhone(passengerPhone);
            passengerUser.setState((byte) 0);
            passengerUser.setGmtCreate(LocalDateTime.now());
            passengerUserMapper.insert(passengerUser);
        }


        //如果不存在，插入用户信息


        return ResponseResult.success();
    }


    public ResponseResult getUserByPhone(String phone){

        PassengerUser passengerUser = passengerUserMapper.selectOne(new QueryWrapper<PassengerUser>().eq("passenger_phone", phone));
        if(passengerUser ==null){
            return ResponseResult.fail(CommonStatusEnum.USER_NOT_EXISTS.getCode(),CommonStatusEnum.USER_NOT_EXISTS.getValue());
        }
        return ResponseResult.success(passengerUser);
    }

}
