package com.seeu.java.traveling_is_fun.pojo;

import javax.persistence.*;

@Entity
public class PostRating {

    @EmbeddedId
    PostRatingKeys id;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    Post post;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    int rating;

    public PostRating() {
    }

    public PostRating(PostRatingKeys id, Post post, User user, int rating) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.rating = rating;
    }

    public PostRatingKeys getId() {
        return id;
    }

    public void setId(PostRatingKeys id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
