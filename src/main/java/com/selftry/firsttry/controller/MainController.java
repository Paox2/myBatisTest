package com.selftry.firsttry.controller;

import com.selftry.firsttry.entity.Account;
import com.selftry.firsttry.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController extends WebMvcConfigurerAdapter {
    @Autowired
    AccountService accountService;

    @RequestMapping("/admin")
    @PreAuthorize(value = "hasRole('admin')")
    @ResponseBody
    public String sayAdmin() {
        System.out.println("Hello, admin!");
        return "Hello, admin!";
    }

    @RequestMapping("/user")
    @PreAuthorize(value = "hasRole('user')")
    @ResponseBody
    public String sayUser() {
        System.out.println("Hello, user!");
        return "Hello, user!";
    }

    @RequestMapping("/both")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    @ResponseBody
    public String sayBoth() {
        System.out.println("Hello, admin, user!");
        return "Hello, admin, user!";
    }

    @RequestMapping("/logining")
    @ResponseBody
    public String logining() {
        System.out.println("Hello");
        return "Hello";
    }

    @RequestMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/accessDenied")
    @ResponseBody
    public String accessDenied() {
        return "Cannot access";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "logout";
    }
}