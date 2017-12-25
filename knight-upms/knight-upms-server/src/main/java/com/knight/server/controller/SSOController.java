package com.knight.server.controller;

import com.knight.common.res.ServerResponse;
import com.knight.common.util.PropertiesFileUtil;
import com.knight.common.util.RedisUtil;
import com.knight.common.util.StringUtil;
import com.knight.upms.client.shiro.session.UpmsSession;
import com.knight.upms.client.shiro.session.UpmsSessionDao;
import com.knight.upms.common.UpmsResultConstant;
import com.knight.upms.dao.model.UpmsSystem;
import com.knight.upms.dao.model.UpmsSystemExample;
import com.knight.upms.rpc.api.UpmsSystemService;
import com.knight.upms.rpc.api.UpmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.UUID;

@Controller
@RequestMapping("/sso")
@Api(value = "单点登录管理", description = "单点登录管理")
public class SSOController {
    private final static Logger _log = LoggerFactory.getLogger(SSOController.class);

    //全局会话key
    private final static String KNIGHT_UPMS_SERVER_SESSION_ID = "knight-upms-server-session-id";
    //全局会话key 列表
    private final static String KNIGHT_UPMS_SERVER_SESSION_IDS = "knight-upms-server-session-ids";
    //code ky
    private final static String KNIGHT_UPMS_SERVER_CODE = "knight-upms-server-code";

    @Autowired
    UpmsSystemService upmsSystemService;

    @Autowired
    UpmsUserService upmsUserService;

    @Autowired
    UpmsSessionDao upmsSessionDao;

    @ApiOperation(value = "认证中心首页")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) throws Exception {
        String appid = request.getParameter("appid");
        String backurl = request.getParameter("backurl");
        if (StringUtils.isBlank(appid))
            throw new RuntimeException("无效访问!");
        //判断请求认证系统是否注册
        UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
        upmsSystemExample.createCriteria()
                .andNameEqualTo(appid);
        int count = upmsSystemService.countByExample(upmsSystemExample);
        if (0 == count)
            throw new RuntimeException(String.format("未注册的系统:%s", appid));
        return "redirect:/sso/login?backurl=" + URLEncoder.encode(backurl, "utf-8");
    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        if (StringUtils.isBlank(username))
            return ServerResponse.createByErrorCodeMessage(UpmsResultConstant.EMPTY_USERNAME.code, "账号不能为空");
        if (StringUtils.isBlank(password))
            return ServerResponse.createByErrorCodeMessage(UpmsResultConstant.EMPTY_PASSWORD.code, UpmsResultConstant.EMPTY_PASSWORD.message);

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String sessionId = session.getId().toString();
        //如果已经登录，则回调 ，防止重复登录
        String hashCode = RedisUtil.get(KNIGHT_UPMS_SERVER_SESSION_ID + "_" + sessionId);
        //code检验值
        if (StringUtils.isBlank(hashCode)) {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            try {
                if (BooleanUtils.toBoolean(rememberMe))
                    usernamePasswordToken.setRememberMe(true);
                else
                    usernamePasswordToken.setRememberMe(false);
            } catch (UnknownAccountException e) {
                return ServerResponse.createByErrorCodeMessage(UpmsResultConstant.INVALID_USERNAME.code, "账号或密码错误");
            } catch (IncorrectCredentialsException e) {
                return ServerResponse.createByErrorCodeMessage(UpmsResultConstant.INVALID_PASSWORD.code, "账号或密码错误");

            } catch (LockedAccountException e) {
                return ServerResponse.createByErrorCodeMessage(UpmsResultConstant.INVALID_ACCOUNT.code, "账号已被锁定!");
            }
            //更新session装填
            upmsSessionDao.updateStatus(sessionId, UpmsSession.OnlineStatus.on_line);
            //全局会话sessionId 列表，供会话管理
            RedisUtil.lpush(KNIGHT_UPMS_SERVER_SESSION_IDS, sessionId.toString());
            //默认验证账号密码正确，创建cdoe
            String code = UUID.randomUUID().toString();
            //全局会话的code
            RedisUtil.set(KNIGHT_UPMS_SERVER_SESSION_ID + "_" + sessionId, code, (int) (subject.getSession().getTimeout() / 1000));

        }
        //回调登录前地址
        String backurl = request.getParameter("backurl");
        if (StringUtils.isBlank(backurl)) {
            UpmsSystem upmsSystem = upmsSystemService.selectUpmsSystemByName(PropertiesFileUtil.getInstance().get("app.name"));
            backurl = null == upmsSystem ? "/" : upmsSystem.getBasepath();
            return ServerResponse.createBySuccess(UpmsResultConstant.SUCCESS.message, backurl);
        } else {
            return ServerResponse.createBySuccess(UpmsResultConstant.SUCCESS.message, backurl);
        }

    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ServerResponse login(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String serverSessionId = session.getId().toString();
        //如果已经登录，则回调
        String code = RedisUtil.get(KNIGHT_UPMS_SERVER_SESSION_ID + "_" + serverSessionId);
        //
        if (StringUtils.isNotBlank(code)) {
            //回调
            String backurl = request.getParameter("backurl");
            String username = (String) subject.getPrincipal();

            if (StringUtils.isBlank(backurl)) {

            } else {

            }
            return null;
        }
        return null;
    }


    @ApiOperation(value = "检验code")
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse code(HttpServletRequest request) {
        String codeParam = request.getParameter("code");
        String code = RedisUtil.get(KNIGHT_UPMS_SERVER_CODE + "_" + codeParam);
        if (StringUtils.isBlank(codeParam) || !codeParam.equals(code)) {
            return ServerResponse.createByErrorCodeMessage(UpmsResultConstant.FAILED.code, "无效的code");
        }
        return ServerResponse.createBySuccess(code);
    }

    @ApiOperation(value = "退出登录")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ServerResponse logout(HttpServletRequest request) {
        //退出登录
        SecurityUtils.getSubject().logout();
        //退回原地址
        String redirectUrl = request.getHeader("Referer");
        if (null == redirectUrl) {
            redirectUrl = "/";
        }
        return ServerResponse.createBySuccessMessage("退出成功");
    }
}
