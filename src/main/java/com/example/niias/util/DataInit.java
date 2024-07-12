/*
package com.example.niias.util;

import com.example.niias.models.User;
import com.example.niias.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInit implements CommandLineRunner {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Override
    public void run(String... args) {
        seedData();
    }

    private void seedData() {
        User user = new User("admin", "admin", "ROLE_ADMIN");

        userServiceImpl.registerUser(user);
    }
}*/