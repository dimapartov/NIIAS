package com.example.niias.web.controllers;

import com.example.niias.services.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ParameterService parameterService;


    @GetMapping("/login")
    public String getLoginPage(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "Неправильное имя пользователя или пароль.");
        }
        return "user-login";
    }

    @GetMapping("/panel")
    public String getUserPanelPage(Model model) {
        model.addAttribute("parametersCommonType", parameterService.getParametersByType("Инфраструктура общего пользования"));
        model.addAttribute("parametersUncommonType", parameterService.getParametersByType("Инфраструктура необщего пользования"));
        return "user-panel";
    }

}