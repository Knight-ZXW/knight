package com.knight.server.controller.manage;

import com.knight.common.base.BaseController;
import com.knight.upms.rpc.api.UpmsLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(value = "日志管理",description = "日志管理")
@RequestMapping("/manage/log")
public class UpmsLogController extends BaseController{
    private static Logger _log = LoggerFactory.getLogger(UpmsLogController.class);
    @Autowired
    private UpmsLogService upmsLogService;

    @ApiOperation(value = "日志列表")
    @RequiresPermissions("upms:log:read")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "/manage/log/index.jsp";
    }

}
