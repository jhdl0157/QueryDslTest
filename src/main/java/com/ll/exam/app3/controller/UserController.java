package com.ll.exam.app3.controller;

import com.ll.exam.app3.entity.SiteUser;
import com.ll.exam.app3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/save")
    public SiteUser save(String username,String email){
        return userService.save(username,email);
    }

    @GetMapping("/get/{id}")
    public SiteUser getUser(@PathVariable("id") Long id ){
        SiteUser user=userService.findId(id);
        return user;
    }

}
