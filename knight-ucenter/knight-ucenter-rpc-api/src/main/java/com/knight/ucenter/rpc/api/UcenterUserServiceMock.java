package com.knight.ucenter.rpc.api;

import com.knight.common.base.BaseServiceMock;
import com.knight.ucenter.dao.mapper.UcenterUserMapper;
import com.knight.ucenter.dao.model.UcenterUser;
import com.knight.ucenter.dao.model.UcenterUserExample;

/**
* 降级实现UcenterUserService接口
* Created by shuknight on 2017/11/17.
*/
public class UcenterUserServiceMock extends BaseServiceMock<UcenterUserMapper, UcenterUser, UcenterUserExample> implements UcenterUserService {

}
