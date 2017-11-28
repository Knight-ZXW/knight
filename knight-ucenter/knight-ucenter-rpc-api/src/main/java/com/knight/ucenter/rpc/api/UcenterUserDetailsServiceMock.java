package com.knight.ucenter.rpc.api;

import com.knight.common.base.BaseServiceMock;
import com.knight.ucenter.dao.mapper.UcenterUserDetailsMapper;
import com.knight.ucenter.dao.model.UcenterUserDetails;
import com.knight.ucenter.dao.model.UcenterUserDetailsExample;

/**
* 降级实现UcenterUserDetailsService接口
* Created by shuzheng on 2017/11/28.
*/
public class UcenterUserDetailsServiceMock extends BaseServiceMock<UcenterUserDetailsMapper, UcenterUserDetails, UcenterUserDetailsExample> implements UcenterUserDetailsService {

}
