package com.seeu.java.traveling_is_fun.controller;

import com.seeu.java.traveling_is_fun.pojo.Comment;
import com.seeu.java.traveling_is_fun.pojo.Post;
import com.seeu.java.traveling_is_fun.pojo.User;
import com.seeu.java.traveling_is_fun.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PostController {
    private PostService postService;


    @PostMapping("/posts/create")
    public void createPost(@RequestBody Post post) {
        postService.createPost(post.getId(), post.getTitle(), post.getContent(), post.getAuthor(), post.getCategory());

    }





}
