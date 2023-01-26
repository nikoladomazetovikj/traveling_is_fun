package com.seeu.java.traveling_is_fun.controller;

import com.seeu.java.traveling_is_fun.controller.request.PostRequest;
import com.seeu.java.traveling_is_fun.pojo.Comment;
import com.seeu.java.traveling_is_fun.pojo.Post;
import com.seeu.java.traveling_is_fun.service.CommentService;
import com.seeu.java.traveling_is_fun.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }


    @GetMapping("/posts/allPosts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("posts/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/posts/create")
    public void createPost(@RequestBody PostRequest post) {
        postService.createPost(post.title, post.content, post.userId, post.category);

    }

    @PutMapping("/posts/edit/{id}")
    public void editPost(@PathVariable Long id, @RequestBody PostRequest post) {
        postService.editPost(id, post.title, post.content, post.category);
    }

    @DeleteMapping("/posts/delete/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @GetMapping("/comments")
    public List<Comment> findAll() {
        return commentService.findAll();
    }


}
