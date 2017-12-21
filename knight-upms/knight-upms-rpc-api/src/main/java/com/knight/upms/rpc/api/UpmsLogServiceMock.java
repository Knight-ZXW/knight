package com.knight.upms.rpc.api;

import com.knight.common.base.BaseServiceMock;
import com.knight.upms.dao.mapper.UpmsLogMapper;
import com.knight.upms.dao.model.UpmsLog;
import com.knight.upms.dao.model.UpmsLogExample;

/**
* 降级实现UpmsLogService接口
* Created by shuknight on 2017/12/12.
*/
public class UpmsLogServiceMock extends BaseServiceMock<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

}
