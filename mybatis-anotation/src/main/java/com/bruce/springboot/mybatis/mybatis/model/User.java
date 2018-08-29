package com.bruce.springboot.mybatis.mybatis.model;

import java.io.Serializable;

/**
 * Created by bruce on 2018/8/29.
 */
public class User implements Serializable {
    private Long id;
    private String name;
    private String password;

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "id: "+id + ", name: " + name + ", passwod: " +password;
    }
}
