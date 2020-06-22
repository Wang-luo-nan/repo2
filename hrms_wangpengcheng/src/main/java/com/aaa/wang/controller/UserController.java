package com.aaa.wang.controller;

import com.aaa.wang.model.User;
import com.aaa.wang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: hrms_wangpengcheng
 * @description:
 * @author: Mr.Wang
 * @create: 2020-06-19 09:41
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有员工信息
     * @param map
     * @return
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<User> query(Map map){
        List<User> userList = userService.query1();
        return userList;
    }

    /**
     * 添加员工
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public String addUser(User user){
        int result= userService.addUser(user);
        return "redirect:queryAll";
    }
    @PostMapping("/queryName")
    @ResponseBody
    public List<User> queryUsername(String username){
        List<User> userList = userService.queryName(username);
        System.out.println(userList);
        return userList;
    }
    @PostMapping("/deleteById")
    public int deleteById(Integer userid){
        return userService.deleteById(userid);
    }
}
