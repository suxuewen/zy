package com.zhiyou100.zy.model;

import com.zhiyou100.zy.web.utils.Md5utils;

public class Admin {
    private Integer id;

    private String loginName;

    private String loginPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null :loginName.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : Md5utils.getMd5(loginPwd.trim());
    }
}