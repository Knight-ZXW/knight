package com.knight.common;


import com.knight.common.base.BaseResult;

/**
 * ucenter系统常量枚举类
 * Created by shuknight on 2017/4/26.
 */
public class UcenterResult extends BaseResult {

    public UcenterResult(UcenterResultConstant cmsResultConstant, Object data) {
        super(cmsResultConstant.getCode(), cmsResultConstant.getMessage(), data);
    }

}
