package com.example.niias.services;

import com.example.niias.models.Admin;
import com.example.niias.repositories.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class RegistrationServiceImpl {

    private AdminRepository adminRepository;
    private PasswordEncoder passwordEncoder;


    public RegistrationServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerAdmin(Admin newAdmin) {
        Optional<Admin> adminByUsername = this.adminRepository.findAdminByUsername(newAdmin.getUsername());
        if (adminByUsername.isPresent()) {
            throw new RuntimeException("Username is already used");
        }
        newAdmin.setRole("ADMIN");
        newAdmin.setPassword(passwordEncoder.encode(newAdmin.getPassword()));
        this.adminRepository.saveAndFlush(newAdmin);
    }
}