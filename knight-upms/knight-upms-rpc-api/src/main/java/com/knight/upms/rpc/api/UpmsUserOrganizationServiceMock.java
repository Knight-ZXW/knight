package com.knight.upms.rpc.api;

import com.knight.common.base.BaseServiceMock;
import com.knight.upms.dao.mapper.UpmsUserOrganizationMapper;
import com.knight.upms.dao.model.UpmsUserOrganization;
import com.knight.upms.dao.model.UpmsUserOrganizationExample;

/**
* 降级实现UpmsUserOrganizationService接口
* Created by shuzheng on 2017/12/12.
*/
public class UpmsUserOrganizationServiceMock extends BaseServiceMock<UpmsUserOrganizationMapper, UpmsUserOrganization, UpmsUserOrganizationExample> implements UpmsUserOrganizationService {

}
