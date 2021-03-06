package com.knight.common;

/**
 * ucenter系统接口结果常量枚举类
 * Created by shuknight on 2017/4/26.
 */
public enum UcenterResultConstant {

    FAILED(0, "failed"),
    SUCCESS(1, "success");

    public int code;

    public String message;

    UcenterResultConstant(int code, String message) {
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

}
