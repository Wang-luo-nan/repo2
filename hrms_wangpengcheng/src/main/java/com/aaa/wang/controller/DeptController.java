package com.aaa.wang.controller;

import com.aaa.wang.model.Dept;
import com.aaa.wang.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: hrms_wangpengcheng
 * @description:
 * @author: Mr.Wang
 * @create: 2020-06-19 11:44
 **/
@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门所有信息
     * @return
     */
    @PostMapping("/queryAllDept")
    @ResponseBody
    public List<Dept> queryAll(){
        return deptService.queryAllDept();
    }
}
