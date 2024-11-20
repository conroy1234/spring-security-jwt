package com.jwt.security.spring_security_jwt.service;

import com.jwt.security.spring_security_jwt.config.JwtService;
import com.jwt.security.spring_security_jwt.entity.Role;
import com.jwt.security.spring_security_jwt.entity.User;
import com.jwt.security.spring_security_jwt.repository.UserRepository;
import com.jwt.security.spring_security_jwt.request.AuthenticationRequest;
import com.jwt.security.spring_security_jwt.request.RegisterRequest;
import com.jwt.security.spring_security_jwt.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    private AuthenticationManager manager;

    private final JwtService jwtService;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );

        var usesr= userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(usesr);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
