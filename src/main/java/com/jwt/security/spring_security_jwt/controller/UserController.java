package com.jwt.security.spring_security_jwt.controller;

import com.jwt.security.spring_security_jwt.entity.User;
import com.jwt.security.spring_security_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/find")
    public List<User> findAll(){
        return userService.getUser();
    }
}
