package com.knight.upms.rpc.api;

import com.knight.common.base.BaseServiceMock;
import com.knight.upms.dao.mapper.UpmsSystemMapper;
import com.knight.upms.dao.model.UpmsSystem;
import com.knight.upms.dao.model.UpmsSystemExample;

/**
* 降级实现UpmsSystemService接口
* Created by shuknight on 2017/12/12.
*/
public class UpmsSystemServiceMock extends BaseServiceMock<UpmsSystemMapper, UpmsSystem, UpmsSystemExample> implements UpmsSystemService {

}
