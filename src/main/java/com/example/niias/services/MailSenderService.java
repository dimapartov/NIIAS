package com.example.niias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MailSenderService {

    @Value("${spring.mail.username}")
    private String userName;

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendSimpleMail(String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userName);
        message.setFrom(userName);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);

    }

}