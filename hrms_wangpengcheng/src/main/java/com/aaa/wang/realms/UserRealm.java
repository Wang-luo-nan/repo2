package com.aaa.wang.realms;

import com.aaa.wang.model.User;
import com.aaa.wang.service.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @Description:
* @Param:
* @return:
* @Author: Mr.Wang
* @Date: 2020/6/19
*/
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserServiceImpl userService;

    @Override
     /**
      *
      * @author yay
      * @param authenticationToken 从前端传过来的token 信息（用户名和密码）
      * @updateTime 2020/01/07 15:46
      * @throws AuthenticationException
      * @return org.apache.shiro.authc.AuthenticationInfo 认证信息 ，从数据库中查出来的用户信息
      */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取前端的token
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //前端用户名
        String username = token.getUsername();
        //数据库中取到的用户对象
        User user = userService.findUserByName(username);
        if (user == null){
            throw new UnknownAccountException("账号不存在");
        }
        //查询出 前端用户名 对应的数据库的用户名和对应的数据库的密码
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),this.getName());
        return info;
    }

    /**
     * 返回授权信息
     * @param principalCollection 登录后的身份集合
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录后的用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名获取到对应的角色集合或者权限集合
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.setStringPermissions(userService.findPermissionByName(username));

        return authorizationInfo;
    }
}
