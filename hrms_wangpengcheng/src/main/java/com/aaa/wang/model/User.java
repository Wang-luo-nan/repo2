package com.aaa.wang.model;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userid;

    private String username;

    private Integer deptid;

    private String email;

    private String phonenum;

    private Integer status;

    private String password;

    private String salt;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public User() {
    }

    public User(Integer userid, String username, Integer deptid, String email, String phonenum, Integer status, String password, String salt, Dept dept) {
        this.userid = userid;
        this.username = username;
        this.deptid = deptid;
        this.email = email;
        this.phonenum = phonenum;
        this.status = status;
        this.password = password;
        this.salt = salt;
        this.dept = dept;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}