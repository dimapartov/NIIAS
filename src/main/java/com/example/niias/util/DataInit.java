package com.example.niias.util;

import com.example.niias.models.User;
import com.example.niias.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInit implements CommandLineRunner {

    @Autowired
    UserService userService;


    @Override
    public void run(String... args) {
        seedData();
    }


    private void seedData() {
        if (!userService.existsByUsername("admin")) {
            User user = new User("admin", "admin", "ROLE_ADMIN");
            userService.registerUser(user);
        } else {
            System.out.println("User 'admin' already exists.");
        }
    }

}