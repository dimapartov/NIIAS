package com.example.niias.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String getLoginPage(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "Неправильное имя пользователя или пароль.");
        }
        return "user-login";
    }

    @GetMapping("/panel")
    public String getUserPanelPage() {
        return "redirect:/admin/parameters";
    }
}
