package com.southwind.controller;

import com.southwind.entity.Account;
import com.southwind.entity.User;
import com.southwind.repository.AdminRepository;
import com.southwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountHandler {

    @Resource
    private UserRepository userRepository;
    @Resource
    private AdminRepository adminRepository;

    @GetMapping("/login/{username}/{password}/{type}")
    public Account login(@PathVariable("username") String username,
                         @PathVariable("password") String password,
                         @PathVariable("type") String type){
        Account account = null;
        switch (type){
            case "user":
                account = userRepository.login(username, password);
                break;
            case "admin":
                account = adminRepository.login(username, password);
                break;
        }
        return account;
    }

    @GetMapping("/register/{username}/{password}/{nickname}")
    public void register(@PathVariable("username") String username,
                            @PathVariable("password") String password,
                            @PathVariable("nickname") String nickname){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        userRepository.saveRegister(user);
    }

}
