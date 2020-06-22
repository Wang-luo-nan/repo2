package com.aaa.wang.mapper;

import com.aaa.wang.model.Dept;

import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptid);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptid);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    List<Dept> queryAllDept();
}