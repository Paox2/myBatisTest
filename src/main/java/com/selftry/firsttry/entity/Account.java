package com.selftry.firsttry.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Account", description = "account detail")
public class Account {
    @ApiModelProperty(name="username", value="user name", required = true)
    private String username;
    @ApiModelProperty(name="password", value="user pwd", required = true)
    private String password;
    @ApiModelProperty(name="userId", value="user id", required = true)
    private Integer userId;
    @ApiModelProperty(name="role", value="user role", required = true)
    private String role;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                ", role='" + role + '\'' +
                '}';
    }
}
