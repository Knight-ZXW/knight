package com.knight.ucenter.rpc.api;

import com.knight.common.base.BaseServiceMock;
import com.knight.ucenter.dao.mapper.UcenterUserLogMapper;
import com.knight.ucenter.dao.model.UcenterUserLog;
import com.knight.ucenter.dao.model.UcenterUserLogExample;

/**
* 降级实现UcenterUserLogService接口
* Created by shuknight on 2017/11/28.
*/
public class UcenterUserLogServiceMock extends BaseServiceMock<UcenterUserLogMapper, UcenterUserLog, UcenterUserLogExample> implements UcenterUserLogService {

}
