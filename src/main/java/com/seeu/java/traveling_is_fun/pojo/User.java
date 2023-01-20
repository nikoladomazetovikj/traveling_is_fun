package com.seeu.java.traveling_is_fun.pojo;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "user_name")

    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "is_admin")
    private boolean isAdmin;
    @Column(name = "is_bloger")
    private boolean isBloger;

    public User() {
    }

    public User(Long id, String name, String email, String userName, String password, boolean isAdmin, boolean isBloger) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isBloger = isBloger;
    }

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isBloger() {
        return isBloger;
    }

    public void setBloger(boolean bloger) {
        isBloger = bloger;
    }
}
