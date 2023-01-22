package com.seeu.java.traveling_is_fun.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name="country",nullable = true)
    private String country;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "is_admin", columnDefinition = "boolean default false", nullable = false)
    private boolean isAdmin;
    @Column(name = "is_bloger", columnDefinition = "boolean default true", nullable = false)
    private boolean isBlogger;

    @ManyToMany
    @JoinTable(
            name = "post_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    List<Post> likedPosts;

    @OneToMany(mappedBy = "user")
    List<PostRating> ratings;

    public User() {
    }

    public User(Long id, String name, String email, String userName, String password, boolean isAdmin, boolean isBlogger) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isBlogger = isBlogger;
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

    public boolean isBlogger() {
        return isBlogger;
    }

    public void setBlogger(boolean bloger) {
        isBlogger = bloger;
    }
}
