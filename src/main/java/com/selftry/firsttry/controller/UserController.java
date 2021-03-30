package com.selftry.firsttry.controller;

import com.selftry.firsttry.mapper.UserMapper;
import com.selftry.firsttry.entity.User;
import com.selftry.firsttry.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Api(value = "user-controller", description = "user related class", tags = {"user"})
@SwaggerDefinition(info = @Info(title="firsttest", version="1.0", description = "Wendi"))
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/helloWorld")
    public String hello() {return "Hello World";}

    @GetMapping("/testGetAllUser")
    public String testGetAllUser() {
        List<User> userList = userService.findAllUsers();
        StringBuilder list = new StringBuilder();
        for (User user : userList) {
            list.append(user.toString()).append("\n");
        }
        return list.toString();
    }

    @GetMapping("/testGetUserById")
    public String testGetUserById() {
        User user = userService.findUserById(0);
        return user.toString();
    }

    @GetMapping("/testGetUserByAge")
    public String testGetUserByAge() {
        List<User> userList = userService.findUserByAge(13);
        StringBuilder list = new StringBuilder();
        for (User user : userList) {
            list.append(user.toString()).append("\n");
        }
        return list.toString();
    }

    @GetMapping("/testGetUserByName")
    public String testGetUserByName() {
        List<User> userList = userService.findUserByName("Tom");
        StringBuilder list = new StringBuilder();
        for (User user : userList) {
            list.append(user.toString()).append("\n");
        }
        return list.toString();
    }

    @GetMapping("/testAddUser")
    public String testAddUser() {
        String message = userService.addUser(new User("Jack", 15, 2));
        return message;
    }

    @GetMapping("/testUpdateUser")
    public String testUpdateUser() {
        String message = userService.updateUser(new User("Jack", null, 1));
        return message;
    }

    @GetMapping("/testDeleteUser")
    public String testDeleteUser() {
        String message = userService.deleteUserById(2);
        return message;
    }
}