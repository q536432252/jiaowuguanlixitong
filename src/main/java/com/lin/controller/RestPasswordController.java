package com.lin.controller;


import com.lin.exception.CustomException;
import com.lin.pojo.UserLogin;
import com.lin.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class RestPasswordController {

    @Autowired
    private UserLoginService userLoginService;



    // 本账户密码重置
    @RequestMapping(value = "/passwordRest", method = {RequestMethod.POST})
    public String passwordRest(String oldPassword, String password1) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        UserLogin userlogin = userLoginService.selectByName(username);

        if (!oldPassword.equals(userlogin.getPassword())) {
            throw new CustomException("旧密码不正确");
        } else {
            //改登录密码
            userlogin.setPassword(password1);
            //userLoginService.updateByName(username, userlogin);
            userLoginService.updateByName(userlogin);
        }

        return "redirect:/logout";
    }

}
