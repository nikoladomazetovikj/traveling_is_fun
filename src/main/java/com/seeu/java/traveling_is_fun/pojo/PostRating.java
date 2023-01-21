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
}
