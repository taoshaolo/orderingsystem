package com.southwind.feign;

import com.southwind.entity.Account;
import com.southwind.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "account")
public interface AccountFeign {

    @GetMapping("/account/login/{username}/{password}/{type}")
    public Account login(@PathVariable("username") String username,
                         @PathVariable("password") String password,
                         @PathVariable("type") String type);

    @GetMapping("/account/register/{username}/{password}/{nickname}")
    public Account saveRegister(@PathVariable("username")  String username,
                             @PathVariable("password") String password,
                             @PathVariable("nickname") String nickname);
}
