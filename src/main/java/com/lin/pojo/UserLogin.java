package com.lin.pojo;

import java.io.Serializable;

public class UserLogin implements Serializable {
    public Integer userID;
    public String userName;
    public String password;
    public Integer role;

    public UserLogin() {
    }

    public UserLogin(Integer userID, String userName, String password, Integer role) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
