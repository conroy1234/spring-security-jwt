package com.jwt.security.spring_security_jwt.repository;

import com.jwt.security.spring_security_jwt.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
    Optional<User> findByEmail(String email);
}
