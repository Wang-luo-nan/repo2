package com.aaa.wang.service;

import com.aaa.wang.model.User;

import java.util.List;
import java.util.Set;

/**
 * @program: hrms_wangpengcheng
 * @description:
 * @author: Mr.Wang
 * @create: 2020-06-19 09:27
 **/
public interface UserService {
    List<User> query1();
    int addUser(User user);

    List<User> queryName(String username);
    User findUserByName(String username);
    Set<String> findPermissionByName(String username);

    int deleteById(Integer id);


}
