package com.example.niias.web.controllers;

import com.example.niias.services.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailSenderService mailSenderService;


    @GetMapping("/sendMail")
    public @ResponseBody String sendMail(@RequestParam String name,
                                         @RequestParam String phone,
                                         @RequestParam String email,
                                         @RequestParam String totalCost) {
        String subject = "Запрос на расчет стоимости";
        String body = "Имя: " + name + "\n" +
                "Телефон: " + phone + "\n" +
                "Email: " + email + "\n" +
                "Итоговая стоимость: " + totalCost;

        mailSenderService.sendSimpleMail(subject, body);

        return "Запрос успешно отправлен. Итоговая стоимость: " + totalCost;
    }

}