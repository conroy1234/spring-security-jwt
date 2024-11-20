package com.jwt.security.spring_security_jwt.controller;

import com.jwt.security.spring_security_jwt.request.AuthenticationRequest;
import com.jwt.security.spring_security_jwt.request.RegisterRequest;
import com.jwt.security.spring_security_jwt.response.AuthenticationResponse;
import com.jwt.security.spring_security_jwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
     return ResponseEntity.ok(authenticationService.authenticate(request));
    }


}
