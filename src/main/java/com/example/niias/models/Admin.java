package com.example.niias.models;

import jakarta.persistence.*;


@Entity
@Table(name = "admins")
public class Admin {

    private long id;
    private String username;
    private String password;
    private String role;


    protected Admin() {}

    public Admin(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}