package com.example.niias.config;

import com.example.niias.repositories.AdminRepository;
import com.example.niias.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private AdminRepository adminRepository;
    @Autowired
    public void setUserRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(adminRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(new RequestAttributeSecurityContextRepository(), new HttpSessionSecurityContextRepository());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, SecurityContextRepository securityContextRepository) throws Exception {
        http.authorizeHttpRequests(
                authorizeHttpRequests -> authorizeHttpRequests
                                        .requestMatchers("/", "/admin/login").permitAll()
                                        .requestMatchers("/admin/panel").hasRole("ADMIN").anyRequest().authenticated()
        )
        .formLogin((formLogin) -> formLogin.loginPage("/admin/login").usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).defaultSuccessUrl("/admin/panel").failureForwardUrl("/"))
        .logout((logout) -> logout.logoutUrl("/admin/logout").logoutSuccessUrl("/").invalidateHttpSession(true)).securityContext(securityContext -> securityContext.securityContextRepository(securityContextRepository));;
        return http.build();
    }
}