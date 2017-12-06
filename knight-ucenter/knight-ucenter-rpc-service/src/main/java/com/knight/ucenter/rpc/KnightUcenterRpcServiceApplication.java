package com.knight.ucenter.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightUcenterRpcServiceApplication {
    private static Logger _log = LoggerFactory.getLogger(KnightUcenterRpcServiceApplication.class);
    public static void main(String[] args) {
        _log.info(">>>>> knight-ucenter-rpc-service 正在启动 <<<<<");
        new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
        _log.info(">>>>> knight-ucenter-rpc-service 启动完成 <<<<<");
    }
}
