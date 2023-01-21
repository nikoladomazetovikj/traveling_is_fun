package com.seeu.java.traveling_is_fun.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PostRatingKeys implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "post_id")
    Long postId;
}
