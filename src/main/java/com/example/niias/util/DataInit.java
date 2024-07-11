/*
package com.example.niias.util;

import com.example.niias.models.Admin;
import com.example.niias.repositories.AdminRepository;
import com.example.niias.services.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInit implements CommandLineRunner {

    private final RegistrationServiceImpl registrationService;
    private final AdminRepository userRepository;
    @Autowired
    public DataInit(RegistrationServiceImpl registrationService, AdminRepository userRepository) {
        this.registrationService = registrationService;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        seedData();
    }

    private void seedData() {
        Admin admin = new Admin("admin", "admin", "ADMIN");
        registrationService.registerAdmin(admin);
    }
}*/