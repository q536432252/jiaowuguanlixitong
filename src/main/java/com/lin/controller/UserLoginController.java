package com.lin.controller;

import com.lin.pojo.UserLogin;
import com.lin.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




//@RestController = @Controller + @ResponseBody（返回json数据）
@Controller
public class UserLoginController {

    //Controller层调用Service实现类
    @Autowired
    private UserLoginService userLoginService;


    /**
     * 不使用shiro直接登录
     */
/*
    @PostMapping("/login")
    public String login (String userName, String password) throws Exception{
        System.out.println("no shiro login");
        //判断用户名是否为空
        //StringUtils    org.springframework.util
        if (StringUtils.isEmpty(userName)) {
            System.out.println("no shiro login1");
            return "error";
        }
        //判断password是否为空
        if (StringUtils.isEmpty(password)) {
            System.out.println("no shiro login2");
            return "error";
        }
        UserLogin user = userLoginService.selectByName(userName);
        if (user == null) {
            System.out.println("no shiro login3");
            return "error";
        }
        if (user.getPassword().equals(password)) {

            System.out.println("no shiro login4");
            return "redirect:/admin/allStudent";
            //return "/admin/allStudent";
        }
        return "error";
    }
*/


    @GetMapping("/login")
    public String login() {
        return "../../login";

    }

    /**
     * 使用shiro进行验证
     * @param userLogin
     * @return
     */
    @PostMapping("/login")
    public String login(UserLogin userLogin){
        //System.out.println("Controller ===" + userLogin.getUserName() + "    " + userLogin.getPassword());
        //Subject : org.apache.shiro.subject,
        //subject对象不能直接new ，只能用SecurityUtils得到
        //一个subject对象代表了当前的“user”用户
        Subject subject = SecurityUtils.getSubject();
        //账号密码的令牌
        UsernamePasswordToken token = new UsernamePasswordToken(userLogin.getUserName(), userLogin.getPassword());

        //执行登录请求（失败会有异常抛出）-->传递令牌到Realm中
        subject.login(token);


        //true为能成功登录,这个方法没法判断权限
//        if (subject.isAuthenticated()) {
//            return "/success";
//        }

//        转发(默认forward)和重定向(redirect)的区别
//        相同点
//        都是web开发中资源跳转的方式。
//        不同点
//        转发：一次请求 1.请求转发是服务器内部的跳转 2.地址栏地址不会发生变化 3.可以通过request域传递数据
//        重定向：两次请求 1.请求重定向是浏览器自动发起对跳转目标的请求 2.地址栏地址会发生变化 3.无法通过request域传递数据
//        如果要访问另外的controller方法就要加redirect来实现

        //根据不同的用户权限，返回不同的页面
        if (subject.hasRole("admin")) {
            return "redirect:/admin/showStudent";
        } else if (subject.hasRole("teacher")) {
            return "redirect:/teacher/showCourse";
        } else if (subject.hasRole("student")) {
            return "redirect:/student/showCourse";
        }
        return "redirect:/login";
    }

}
