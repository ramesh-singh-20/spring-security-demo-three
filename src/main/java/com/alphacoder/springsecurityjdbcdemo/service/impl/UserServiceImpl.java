package com.alphacoder.springsecurityjdbcdemo.service.impl;

import com.alphacoder.springsecurityjdbcdemo.model.User;
import com.alphacoder.springsecurityjdbcdemo.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor(onConstructor = @__ ({@Autowired}))
public class UserServiceImpl implements UserService {
    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addUser(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.jdbcUserDetailsManager.createUser(user);
    }
}
