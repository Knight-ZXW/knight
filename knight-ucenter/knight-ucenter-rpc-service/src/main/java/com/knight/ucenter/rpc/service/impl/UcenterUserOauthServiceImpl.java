package com.knight.ucenter.rpc.service.impl;

import com.knight.common.annotation.BaseService;
import com.knight.common.base.BaseServiceImpl;
import com.knight.ucenter.dao.mapper.UcenterUserOauthMapper;
import com.knight.ucenter.dao.model.UcenterUserOauth;
import com.knight.ucenter.dao.model.UcenterUserOauthExample;
import com.knight.ucenter.rpc.api.UcenterUserOauthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UcenterUserOauthService实现
* Created by shuzheng on 2017/11/28.
*/
@Service
@Transactional
@BaseService
public class UcenterUserOauthServiceImpl extends BaseServiceImpl<UcenterUserOauthMapper, UcenterUserOauth, UcenterUserOauthExample> implements UcenterUserOauthService {

    private static Logger _log = LoggerFactory.getLogger(UcenterUserOauthServiceImpl.class);

    @Autowired
    UcenterUserOauthMapper ucenterUserOauthMapper;

}