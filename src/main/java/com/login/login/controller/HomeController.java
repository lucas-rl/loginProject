package com.login.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    String home(){
        return "HOME";
    }

    @GetMapping("/admin")
    String sessao(){
        return "HOME ADMIN";
    }

}
