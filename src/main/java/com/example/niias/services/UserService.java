package com.example.niias.services;

import com.example.niias.models.User;
import com.example.niias.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void registerUser(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.saveAndFlush(newUser);
    }

    public boolean existsByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        return user.isPresent();
    }

}