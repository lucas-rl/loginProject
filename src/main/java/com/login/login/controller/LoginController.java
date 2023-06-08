package com.login.login.controller;

import com.login.login.usecase.LoginUseCase;
import com.login.login.usecase.data.UserRegistration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    LoginUseCase useCase;

    public LoginController(LoginUseCase useCase) {
        this.useCase = useCase;
    }

    @ModelAttribute("user")
    public UserRegistration userRegistration(){
        return new UserRegistration();
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserRegistration userRegistration){
        useCase.register(userRegistration);
        return "redirect:/login/register?success";
    }

    @GetMapping("/register")
    public String registrationForm(){
        return "registration";
    }

}
