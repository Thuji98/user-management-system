package com.mitai.usermanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserManagementController {

    @GetMapping("say")
    public String hello(){
        return "Hello there!";
    }

    @GetMapping("say1")
    public String hello1(){
        return "Hello there1!";
    }

}
