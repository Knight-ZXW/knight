package com.knight.common.base;

import com.knight.common.res.ResponseCode;

/**
 * 统一返回结果类
 * Created by shuknight on 2017/2/18.
 */
public class BaseResult<T> {

    // 状态码：1成功，其他为失败
    public int code;

    // 成功为success，其他为失败原因
    public String message;

    // 数据结果集
    public T data;

    public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private BaseResult(int code){
        this.code = code;
    }
    private BaseResult(int code, T data){
        this.code = code;
        this.data = data;
    }


    private BaseResult(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public static <T> BaseResult<T> createBySuccess(){
        return new BaseResult<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> BaseResult<T> createBySuccessMessage(String msg){
        return new BaseResult<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> BaseResult<T> createBySuccess(T data){
        return new BaseResult<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> BaseResult<T> createBySuccess(String msg,T data){
        return new BaseResult<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }


    public static <T> BaseResult<T> createByError(){
        return new BaseResult<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    public static <T> BaseResult<T> createByErrorMessage(String errorMessage){
        return new BaseResult<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> BaseResult<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new BaseResult<T>(errorCode,errorMessage);
    }
}
