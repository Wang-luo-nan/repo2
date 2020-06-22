package com.aaa.wang.service;

import com.aaa.wang.mapper.UserMapper;
import com.aaa.wang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @program: hrms_wangpengcheng
 * @description:
 * @author: Mr.Wang
 * @create: 2020-06-19 09:27
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有信息
     * @return
     */
    @Override
    public List<User> query1() {
        return userMapper.query1();
    }

    /**
    * @Description: 添加员工信息
    * @Param: [user]
    * @return: int
    * @Author: Mr.Wang
    * @Date: 2020/6/19
    */
    @Override
    public int addUser(User user) {
        int i = userMapper.insertSelective(user);
        if (i > 0){
            System.out.println("添加成功");
        }
        return 0;
    }
    /**
    * @Description: 根据名字查询信息
    * @Param: [username]
    * @return: java.util.List<com.aaa.wang.model.User>
    * @Author: Mr.Wang
    * @Date: 2020/6/19
    */
    @Override
    public List<User> queryName(String username) {
        System.out.println(userMapper.queryName(username)+"1");
        return userMapper.queryName(username);
    }
    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);

    }
    @Override
    public Set<String> findPermissionByName(String username) {
        return userMapper.findPermissionByName(username);
    }
    /**
    * @Description: 逻辑删除改变为禁用状态
    * @Param: [userid]
    * @return: int
    * @Author: Mr.Wang
    * @Date: 2020/6/19
    */
    @Override
    public int deleteById(Integer userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        user.setStatus(2);
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
