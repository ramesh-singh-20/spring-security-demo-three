package com.alphacoder.springsecurityjdbcdemo.controller;

import com.alphacoder.springsecurityjdbcdemo.model.User;
import com.alphacoder.springsecurityjdbcdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__ ({@Autowired}))
public class UserController {
    private final UserService userService;

    @GetMapping(value="/hello")
    public String getHello(){
        return "hello";
    }

    @PostMapping(value = "/user")
    public void addUser(@RequestBody User user){
        this.userService.addUser(user);
    }
}
