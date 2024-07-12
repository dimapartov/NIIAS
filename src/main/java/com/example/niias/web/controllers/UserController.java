package com.example.niias.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "user-login";
    }

    @GetMapping("/panel")
    public String getUserPanelPage() {
        return "user-panel";
    }

}