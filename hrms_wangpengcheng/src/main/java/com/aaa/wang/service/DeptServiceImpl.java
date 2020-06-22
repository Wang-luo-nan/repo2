package com.aaa.wang.service;

import com.aaa.wang.mapper.DeptMapper;
import com.aaa.wang.model.Dept;
import com.aaa.wang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: hrms_wangpengcheng
 * @description:
 * @author: Mr.Wang
 * @create: 2020-06-19 11:39
 **/
@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptMapper deptMapper;
    /**
    * @Description: 查询部门所有信息
    * @Param: []
    * @return: java.util.List<com.aaa.wang.model.Dept>
    * @Author: Mr.Wang
    * @Date: 2020/6/19
    */
    @Override
    public List<Dept> queryAllDept() {
        return deptMapper.queryAllDept();
    }
}
