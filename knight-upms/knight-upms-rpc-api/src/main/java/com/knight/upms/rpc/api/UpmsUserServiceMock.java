package com.knight.upms.rpc.api;

import com.knight.common.base.BaseServiceMock;
import com.knight.upms.dao.mapper.UpmsUserMapper;
import com.knight.upms.dao.model.UpmsUser;
import com.knight.upms.dao.model.UpmsUserExample;

/**
* 降级实现UpmsUserService接口
* Created by shuzheng on 2017/12/12.
*/
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

}
