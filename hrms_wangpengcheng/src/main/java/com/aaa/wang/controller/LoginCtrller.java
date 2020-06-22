package com.aaa.wang.controller;

import com.aaa.wang.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:
* @Param:
* @return:
* @Author: Mr.Wang
* @Date: 2020/6/19
*/
@Controller
@RestController("/login")
public class LoginCtrller {
    @RequestMapping("/login")
    public String login(User user){
        //令牌：身份的凭证
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        //获取Subject  对象：抽象的用户，接入系统的用户
        Subject currentUser = SecurityUtils.getSubject();
        //将信息提交给安全管理器
        try {
            currentUser.login(token);
        }catch (UnknownAccountException uae){
            throw new UnknownAccountException("账号不存在");
        }catch (IncorrectCredentialsException ice){
            throw new IncorrectCredentialsException("密码不匹配");
        }catch (AuthenticationException e) {
            throw new AuthenticationException("认证异常");
        }
        return "redirect:main.html";
    }
}
