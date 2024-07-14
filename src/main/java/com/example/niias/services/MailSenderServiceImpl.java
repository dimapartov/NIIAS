package com.example.niias.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MailSenderServiceImpl {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMail(String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("mr_kubarev@mail.ru");
            message.setFrom(from);
            message.setSubject(subject);
            message.setText(body);
            javaMailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}