package com.jwt.security.spring_security_jwt.service;

import com.jwt.security.spring_security_jwt.entity.User;
import com.jwt.security.spring_security_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUser(){
       return (List<User>) userRepository.findAll();
    }
}
