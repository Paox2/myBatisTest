package com.selftry.firsttry.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "User", description = "User name, age and id")
public class User implements Serializable {
    @ApiModelProperty(name="userName", value="user name", required = true)
    private String userName;
    @ApiModelProperty(name="userAge", value="user age", required = true)
    private Integer userAge;
    @ApiModelProperty(name="userId", value="user id", required = true)
    private Integer userId;
    @ApiModelProperty(name="role", value="user role", required = true)
    private String role;

    public User(String userName, Integer userAge, Integer userId, String role) {
        this.userName = userName;
        this.userAge = userAge;
        this.userId = userId;
        this.role = role;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userId=" + userId +
                ", role='" + role + '\'' +
                '}';
    }
}
