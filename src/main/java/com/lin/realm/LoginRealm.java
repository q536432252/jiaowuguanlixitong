package com.lin.realm;

import com.lin.pojo.Role;
import com.lin.pojo.UserLogin;
import com.lin.service.RoleService;
import com.lin.service.UserLoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


//这个Realm域是用来自定义认证授权的规则
//继承授权的Realm（AuthorizingRealm）类
@Component
public class LoginRealm extends AuthorizingRealm {

    //@Autowired

    //@Autowired
    @Resource(name = "userLoginServiceImpl")
    private UserLoginService userLoginService;

    @Autowired
    private RoleService roleService;

    /**
     * 在这个方法中，进行认证（登录）工作
     * login时调用，把原先放在controller的登录代码放到这里
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();
        //String password = (String)token.getCredentials();
        String password = new String((char[])token.getCredentials());

        //userLogin == null 表示用户不存在, 抛出AuthenticationException异常
        UserLogin userlogin = null;
        try {
            userlogin = userLoginService.selectByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userlogin == null) {
            //没有该用户名
            throw new UnknownAccountException();
        } else if (!password.equals(userlogin.getPassword())) {
            //密码错误
            throw new IncorrectCredentialsException();
        }

        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(userlogin.getUserName(), userlogin.getPassword(), getName());
        return new SimpleAuthenticationInfo(userlogin.getUserName(), userlogin.getPassword(), getName());
    }


    /** 获取授权信息：进行授权工作
     * 授权的前提条件是，认证通过
     * 授权方法不一定会执行，只有某些页面需要授权的时候才会执行该方法
     * @param principalCollection 身份
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取一个可用的用户身份：取决于 登录方法 的返回的第一个参数 new SimpleAuthenticationInfo(userlogin.getUserName(), userlogin.getPassword(), getName());
        String username = (String)super.getAvailablePrincipal(principalCollection);
        UserLogin userLogin = userLoginService.selectByName(username);
        //userLogin.getRole()

        Role role = null;
        try {
            role = roleService.selectByID(userLogin.getRole());
        } catch (Exception e) {
            e.printStackTrace();
        }


        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (role != null) {
            info.addRole(role.getRoleName());
        }
        //给某个人分配角色
        //info.addRole();
        //info.addRoles();

        //给某个人分配 权限
        //info.addStringPermission();

        return info;
    }



}
