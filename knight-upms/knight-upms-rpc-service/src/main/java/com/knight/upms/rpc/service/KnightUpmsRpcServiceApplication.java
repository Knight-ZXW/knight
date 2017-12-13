package com.knight.upms.rpc.service;

import com.knight.upms.dao.model.UpmsPermission;
import com.knight.upms.rpc.service.impl.UpmsApiServiceImpl;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class KnightUpmsRpcServiceApplication {
    private static Logger _log = LoggerFactory.getLogger(KnightUpmsRpcServiceApplication.class);

    public static void main(String[] args) {
        _log.info(">>>>> knight-upms-rpc-service 正在启动 <<<<<");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
        UpmsApiServiceImpl upmsApiService = applicationContext.getBean(UpmsApiServiceImpl.class);
        List<UpmsPermission> upmsPermissions = upmsApiService.selectUpmsPermissionByUpmsUserId(1);
        _log.info("permission count = "+upmsPermissions.size());
        _log.info(">>>>> knight-upms-rpc-service 启动完成 <<<<<");
    }
}
