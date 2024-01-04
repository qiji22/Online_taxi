package com.lwx.internalcommon.dto;


import com.lwx.internalcommon.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    private int code;
    private String message;
    private T data;


    public static <T> ResponseResult success(){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue());
    }

    /*
    * 成功响应的方法
    * */
    public static <T> ResponseResult success(T data){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue()).setData(data);
    }

/* 失败： 统一的失败
 * @param:
 * @return:
 **/
    public static<T> ResponseResult fail(T data){
        return new ResponseResult().setData(data);
    }


    /*
    * 失败： 自定义失败 错误码和提示信息
    * */
    public static ResponseResult fail(int code,String message){
        return new ResponseResult().setCode(code).setMessage(message);
    }

    public static ResponseResult fail(int code,String message,String data){
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }

}
