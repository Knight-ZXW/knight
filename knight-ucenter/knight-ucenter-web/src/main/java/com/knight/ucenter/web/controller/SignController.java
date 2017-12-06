package com.knight.ucenter.web.controller;

import com.knight.common.UcenterResult;
import com.knight.common.UcenterResultConstant;
import com.knight.common.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册控制器
 * Created by shuzheng on 2017/5/2.
 */
@Controller
public class SignController extends BaseController {

    private static Logger _log = LoggerFactory.getLogger(SignController.class);

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {

        return thymeleaf("/reg");
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseBody
    public Object signup(HttpServletRequest request) {

        return new UcenterResult(UcenterResultConstant.SUCCESS, "");
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(Model model) {

        return thymeleaf("/login");
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public Object signin(HttpServletRequest request) {

        return new UcenterResult(UcenterResultConstant.SUCCESS, "");
    }

    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    @ResponseBody
    public String index(Model model) {

        return "signout";
    }

    @RequestMapping(value = "/password_reset", method = RequestMethod.GET)
    public String password_reset(Model model) {

        return thymeleaf("/password");
    }

}