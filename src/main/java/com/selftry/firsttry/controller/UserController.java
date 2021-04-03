package com.selftry.firsttry.controller;

import com.selftry.firsttry.mapper.UserMapper;
import com.selftry.firsttry.entity.User;
import com.selftry.firsttry.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/userOperation")
@Api(value = "user-controller", description = "user related class", tags = {"user"})
@SwaggerDefinition(info = @Info(title="firsttest", version="1.0", description = "Wendi"))
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/helloWorld")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    public String hello() {return "Hello World";}

    @GetMapping("/testGetAllUser")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    public String testGetAllUser() {
        List<User> userList = userService.findAllUsers();
        StringBuilder list = new StringBuilder();
        for (User user : userList) {
            list.append(user.toString()).append("\n");
        }
        return list.toString();
    }

    @GetMapping("/testGetUserById")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    public String testGetUserById() {
        User user = userService.findUserById(0);
        return user.toString();
    }

    @GetMapping("/testGetUserByAge")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    public String testGetUserByAge() {
        List<User> userList = userService.findUserByAge(13);
        StringBuilder list = new StringBuilder();
        for (User user : userList) {
            list.append(user.toString()).append("\n");
        }
        return list.toString();
    }

    @GetMapping("/testGetUserByName")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    public String testGetUserByName() {
        List<User> userList = userService.findUserByName("Tom");
        StringBuilder list = new StringBuilder();
        for (User user : userList) {
            list.append(user.toString()).append("\n");
        }
        return list.toString();
    }

    @GetMapping("/testAddUser")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    public String testAddUser() {
        String message = userService.addUser(new User("Jack", 15, 2, "user"));
        return message;
    }

    @GetMapping("/testUpdateUser")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    public String testUpdateUser() {
        String message = userService.updateUser(new User("Jack", null, 1, "user"));
        return message;
    }

    @GetMapping("/testDeleteUser")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    public String testDeleteUser() {
        String message = userService.deleteUserById(2);
        return message;
    }
}