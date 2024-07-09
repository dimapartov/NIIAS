package com.example.niias.services;

import com.example.niias.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;


public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .map(user ->
                        new User(user.getUsername(),
                                user.getPassword(),
                                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
                )).orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}