package com.knight.ucenter.rpc.service.impl;

import com.knight.common.annotation.BaseService;
import com.knight.common.base.BaseServiceImpl;
import com.knight.ucenter.dao.mapper.UcenterUserLogMapper;
import com.knight.ucenter.dao.model.UcenterUserLog;
import com.knight.ucenter.dao.model.UcenterUserLogExample;
import com.knight.ucenter.rpc.api.UcenterUserLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UcenterUserLogService实现
* Created by shuzheng on 2017/11/28.
*/
@Service
@Transactional
@BaseService
public class UcenterUserLogServiceImpl extends BaseServiceImpl<UcenterUserLogMapper, UcenterUserLog, UcenterUserLogExample> implements UcenterUserLogService {

    private static Logger _log = LoggerFactory.getLogger(UcenterUserLogServiceImpl.class);

    @Autowired
    UcenterUserLogMapper ucenterUserLogMapper;

}