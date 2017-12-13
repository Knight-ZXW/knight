package com.knight.upms.rpc.service;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightUpmsRpcServiceApplication {
    private static Logger _log = LoggerFactory.getLogger(KnightUpmsRpcServiceApplication.class);

    public static void main(String[] args) {
        _log.info(">>>>> knight-upms-rpc-service 正在启动 <<<<<");
        new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
        _log.info(">>>>> knight-upms-rpc-service 启动完成 <<<<<");
    }
}
