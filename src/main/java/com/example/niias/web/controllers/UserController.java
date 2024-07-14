package com.example.niias.web.controllers;


import com.example.niias.services.MailSenderServiceImpl;
import com.example.niias.services.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ParameterService parameterService;

    @Autowired
    private MailSenderServiceImpl mailSenderService;

    @GetMapping("/login")
    public String getLoginPage(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "Неправильное имя пользователя или пароль.");
        }
        return "user-login";
    }

    @GetMapping("/panel")
    public String getUserPanelPage(Model model) {
        model.addAttribute("parametersCommonType", parameterService.getParametersByType("common"));
        model.addAttribute("parametersUncommonType", parameterService.getParametersByType("uncommon"));
        return "user-panel";
    }

    @GetMapping("/sendMail")
    public String sendMail(@RequestParam String name,
                         @RequestParam String phone,
                         @RequestParam String email,
                         @RequestParam String totalCost) {
        String subject = "Запрос на расчет стоимости проекта от: " + email;
        String body = "Поступил запрос от " + name + ". Стоимость: " + totalCost + ". Почта: " + email + ". Телефон: " + phone;
        mailSenderService.sendSimpleMail(subject, body);
        return "redirect:/";
    }
}