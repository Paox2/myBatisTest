package com.selftry.firsttry.controller;

import com.selftry.firsttry.entity.Account;
import com.selftry.firsttry.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/admin")
    @PreAuthorize(value = "hasRole('admin')")
    public String sayAdmin() {
        System.out.println("Hello, admin!");
        return "Hello, admin!";
    }

    @RequestMapping("/user")
    @PreAuthorize(value = "hasRole('user')")
    public String sayUser() {
        System.out.println("Hello, user!");
        return "Hello, user!";
    }

    @RequestMapping("/both")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    public String sayBoth() {
        System.out.println("Hello, admin, user!");
        return "Hello, admin, user!";
    }

    @GetMapping("/testGetAccount")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    public String testGetAccount() {
        Account account = accountService.findAccountByName("Jack");
        return account.toString();
    }

    @RequestMapping("/logining")
    public String logining() {
        System.out.println("Hello");
        return "Hello";
    }
}