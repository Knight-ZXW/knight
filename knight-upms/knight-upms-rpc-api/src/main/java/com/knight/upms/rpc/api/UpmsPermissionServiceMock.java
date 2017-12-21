package com.knight.upms.rpc.api;

import com.knight.common.base.BaseServiceMock;
import com.knight.upms.dao.mapper.UpmsPermissionMapper;
import com.knight.upms.dao.model.UpmsPermission;
import com.knight.upms.dao.model.UpmsPermissionExample;

/**
* 降级实现UpmsPermissionService接口
* Created by shuknight on 2017/12/12.
*/
public class UpmsPermissionServiceMock extends BaseServiceMock<UpmsPermissionMapper, UpmsPermission, UpmsPermissionExample> implements UpmsPermissionService {

}
