package com.blog.dbblog.shiro;

import com.blog.dbblog.entity.User;
import com.blog.dbblog.service.UserService;
import com.blog.dbblog.util.MD5Util;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;


/**
 * @author wuxi
 * @create 2023-08-20
 */

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user  = (User) principalCollection.getPrimaryPrincipal();
        //模拟数据库查询出来的用户角色对应的权限
        String rolePermission = "/admin";
        authorizationInfo.addStringPermission(rolePermission);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进行身份认证中...");
        //获取输入的账号
        String userName = (String) authenticationToken.getPrincipal();

        System.out.println("userName:"+userName+"!!!!!!");

        //获取输入的密码
        //shiro会把密码转为字符，所以这里需要把字符转字符串
        String password = new String((char[]) authenticationToken.getCredentials());
//    System.out.println("password:"+password+"!!!!!!");

        //通过userName从数据库中查找 User对象
        User user = userService.getUserByUserName(userName);

        String s = MD5Util.MD5(password);
        if (user == null || !user.getPassWord().equals(s)) {
            throw new AccountException("用户名或密码不正确");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(),
                user.getPassWord(),
                null,
                getName()
        );
        return authenticationInfo;
    }
}
