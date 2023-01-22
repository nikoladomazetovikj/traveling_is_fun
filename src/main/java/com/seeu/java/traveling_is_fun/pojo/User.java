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

    public User(Long id, String name, String country, String surname, String email, String userName, String password, boolean isAdmin, boolean isBlogger, List<Post> likedPosts, List<PostRating> ratings) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.surname = surname;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isBlogger = isBlogger;
        this.likedPosts = likedPosts;
        this.ratings = ratings;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public void setBlogger(boolean blogger) {
        isBlogger = blogger;
    }

    public List<Post> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(List<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public List<PostRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<PostRating> ratings) {
        this.ratings = ratings;
    }
}
